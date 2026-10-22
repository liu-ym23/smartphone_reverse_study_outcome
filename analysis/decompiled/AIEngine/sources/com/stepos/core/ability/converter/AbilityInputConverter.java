package com.stepos.core.ability.converter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import androidx.lifecycle.j0;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.converter.InferenceInputConverter;
import com.stepos.core.ability.speech.AsrCloudWsSession;
import com.stepos.core.ability.speech.AsrMultiFilesFileStore;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import com.stepos.core.common.util.AsrSseStreamParamKeys;
import com.stepos.core.common.util.TraceIdExtractorKt;
import com.stepos.core.common.util.VadParamKeys;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.SessionRefContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.VideoContent;
import com.stepos.core.data.base.Content;
import dc.h;
import gc.a;
import gc.o;
import gc.q;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.l;
import mb.m;
import v6.b;
import v6.c;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityInputConverter implements InferenceInputConverter {
    private static final String TAG = "AbilityInputConverter";
    private static final int TARGET_SAMPLE_RATE = 16000;
    public static final Companion Companion = new Companion(null);
    private static final Set<String> AUDIO_EXTS = l.s0(new String[]{"wav", "mp3", "m4a", "aac", "ogg", "flac", "amr"});

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean allowsDownsample(ContentParams contentParams) {
        return contentParams != null && contentParams.containsKey(VisionParamKeys.SAMPLE_SIZE);
    }

    private final c.a applyAsrOrchestration(c.a aVar, ContentParams contentParams) {
        String lowerCase;
        if (contentParams == null || !contentParams.containsKey("execution_preference")) {
            return aVar;
        }
        String string = contentParams.getString("execution_preference", "auto");
        if (string != null) {
            lowerCase = string.toLowerCase(Locale.ROOT);
            g.e(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        ExecutionPreference executionPreference = g.b(lowerCase, "local") ? ExecutionPreference.f6387b : g.b(lowerCase, ModelCallFlywheelBizMapper.MODEL_PATH_CLOUD) ? ExecutionPreference.f6388c : ExecutionPreference.f6386a;
        return executionPreference == aVar.f13391g ? aVar : c.a.c(aVar, null, null, executionPreference, null, null, 479);
    }

    private final c.a applyAsrSseStreamExtras(c.a aVar, ContentParams contentParams) {
        boolean z;
        Bundle bundle;
        if (contentParams != null) {
            Bundle bundle2 = new Bundle();
            boolean z3 = true;
            if (contentParams.containsKey(AsrSseStreamParamKeys.VAD_ENABLED)) {
                bundle2.putBoolean(AsrSseStreamParamKeys.VAD_ENABLED, contentParams.getBoolean(AsrSseStreamParamKeys.VAD_ENABLED, false));
                z = true;
            } else {
                z = false;
            }
            if (contentParams.containsKey(AsrSseStreamParamKeys.STREAM_MAX_DURATION_MS)) {
                bundle2.putInt(AsrSseStreamParamKeys.STREAM_MAX_DURATION_MS, ContentParams.getInt$default(contentParams, AsrSseStreamParamKeys.STREAM_MAX_DURATION_MS, 0, 2, null));
                z = true;
            }
            if (contentParams.containsKey(AsrSseStreamParamKeys.FEED_ORDERED)) {
                bundle2.putBoolean(AsrSseStreamParamKeys.FEED_ORDERED, contentParams.getBoolean(AsrSseStreamParamKeys.FEED_ORDERED, false));
            } else {
                z3 = z;
            }
            if (z3) {
                Bundle bundle3 = aVar.f13392i;
                if (bundle3 != null) {
                    Bundle bundle4 = new Bundle(bundle3);
                    bundle4.putAll(bundle2);
                    bundle = bundle4;
                } else {
                    bundle = bundle2;
                }
                return c.a.c(aVar, null, null, null, null, bundle, 383);
            }
        }
        return aVar;
    }

    private final c.a applyCloudScene(c.a aVar, ContentParams contentParams) {
        b cloudScene = parseCloudScene(contentParams);
        return cloudScene == null ? aVar : c.a.c(aVar, null, null, null, cloudScene, null, 447);
    }

    private final c.a applySlaExtras(c.a aVar, ContentParams contentParams) {
        boolean z;
        if (contentParams != null) {
            Bundle bundle = new Bundle();
            Iterator<String> it = contentParams.keys().iterator();
            boolean z3 = false;
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (o.k0(next, "sla.arg.", false)) {
                    bundle.putString(next, contentParams.getString(next, ""));
                    z3 = true;
                }
            }
            if (contentParams.containsKey("sla.executeAtomic")) {
                bundle.putBoolean("sla.executeAtomic", contentParams.getBoolean("sla.executeAtomic", true));
                z3 = true;
            }
            if (contentParams.containsKey("task_priority")) {
                TaskPriority.a aVar2 = TaskPriority.f6396b;
                bundle.putInt("task_priority", contentParams.getInt("task_priority", 2));
            } else {
                z = z3;
            }
            if (z) {
                return c.a.c(aVar, null, null, null, null, bundle, 383);
            }
        }
        return aVar;
    }

    private final c.a applyVadExtras(c.a aVar, ContentParams contentParams) {
        Bundle bundle;
        if (contentParams != null) {
            Bundle bundle2 = new Bundle();
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            applyVadExtras$putInt(contentParams, bundle2, ref$BooleanRef, VadParamKeys.SPEECH_START_MS);
            applyVadExtras$putInt(contentParams, bundle2, ref$BooleanRef, VadParamKeys.SILENCE_DURATION_MS);
            applyVadExtras$putInt(contentParams, bundle2, ref$BooleanRef, VadParamKeys.LEADING_SILENCE_TIMEOUT_MS);
            applyVadExtras$putInt(contentParams, bundle2, ref$BooleanRef, VadParamKeys.MAX_DURATION_MS);
            applyVadExtras$putInt(contentParams, bundle2, ref$BooleanRef, VadParamKeys.LEVEL_INTERVAL_MS);
            applyVadExtras$putFloat(contentParams, bundle2, ref$BooleanRef, VadParamKeys.MIN_SPEECH_RMS);
            applyVadExtras$putFloat(contentParams, bundle2, ref$BooleanRef, VadParamKeys.THRESHOLD);
            applyVadExtras$putBoolean(contentParams, bundle2, ref$BooleanRef, VadParamKeys.LEVEL_ENABLED);
            applyVadExtras$putBoolean(contentParams, bundle2, ref$BooleanRef, VadParamKeys.FEED_ORDERED);
            if (ref$BooleanRef.f10073a) {
                Bundle bundle3 = aVar.f13392i;
                if (bundle3 != null) {
                    Bundle bundle4 = new Bundle(bundle3);
                    bundle4.putAll(bundle2);
                    bundle = bundle4;
                } else {
                    bundle = bundle2;
                }
                return c.a.c(aVar, null, null, null, null, bundle, 383);
            }
        }
        return aVar;
    }

    private static final void applyVadExtras$putBoolean(ContentParams contentParams, Bundle bundle, Ref$BooleanRef ref$BooleanRef, String str) {
        if (contentParams.containsKey(str)) {
            bundle.putBoolean(str, contentParams.getBoolean(str, false));
            ref$BooleanRef.f10073a = true;
        }
    }

    private static final void applyVadExtras$putFloat(ContentParams contentParams, Bundle bundle, Ref$BooleanRef ref$BooleanRef, String str) {
        if (contentParams.containsKey(str)) {
            float f8 = contentParams.getFloat(str, Float.NaN);
            if (Float.isNaN(f8)) {
                f8 = (float) contentParams.getDouble(str, 0.0d);
            }
            bundle.putFloat(str, f8);
            ref$BooleanRef.f10073a = true;
        }
    }

    private static final void applyVadExtras$putInt(ContentParams contentParams, Bundle bundle, Ref$BooleanRef ref$BooleanRef, String str) {
        if (contentParams.containsKey(str)) {
            bundle.putInt(str, ContentParams.getInt$default(contentParams, str, 0, 2, null));
            ref$BooleanRef.f10073a = true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d8 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String audioExtHint(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r3 = 46
            java.lang.String r0 = ""
            java.lang.String r3 = gc.q.H0(r4, r3, r0)
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.g.e(r3, r0)
            int r1 = r3.length()
            r2 = 0
            if (r1 <= 0) goto L1b
            goto L1c
        L1b:
            r3 = r2
        L1c:
            if (r3 == 0) goto L27
            java.util.Set<java.lang.String> r1 = com.stepos.core.ability.converter.AbilityInputConverter.AUDIO_EXTS
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L27
            return r3
        L27:
            java.lang.String r3 = r5.toLowerCase(r4)
            kotlin.jvm.internal.g.e(r3, r0)
            r4 = 59
            java.lang.String r3 = gc.q.J0(r3, r4)
            java.lang.CharSequence r3 = gc.q.L0(r3)
            java.lang.String r3 = r3.toString()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1248335792: goto Ld0;
                case -1007807498: goto Lc4;
                case -586694260: goto Lb8;
                case -586683234: goto Lac;
                case 187078282: goto La0;
                case 187078669: goto L94;
                case 187088417: goto L8b;
                case 187090231: goto L7f;
                case 187090232: goto L76;
                case 187091926: goto L6d;
                case 187099443: goto L63;
                case 1504619009: goto L59;
                case 1504831518: goto L4f;
                case 1505115538: goto L45;
                default: goto L43;
            }
        L43:
            goto Ld8
        L45:
            java.lang.String r4 = "audio/wave"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lb5
            goto Ld8
        L4f:
            java.lang.String r4 = "audio/mpeg"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L88
            goto Ld8
        L59:
            java.lang.String r4 = "audio/flac"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lcd
            goto Ld8
        L63:
            java.lang.String r4 = "audio/wav"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lb5
            goto Ld8
        L6d:
            java.lang.String r4 = "audio/ogg"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Ld9
            goto Ld8
        L76:
            java.lang.String r4 = "audio/mp4"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lc1
            goto Ld8
        L7f:
            java.lang.String r4 = "audio/mp3"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L88
            goto Ld8
        L88:
            java.lang.String r3 = "mp3"
            return r3
        L8b:
            java.lang.String r4 = "audio/m4a"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lc1
            goto Ld8
        L94:
            java.lang.String r4 = "audio/amr"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L9d
            goto Ld8
        L9d:
            java.lang.String r3 = "amr"
            return r3
        La0:
            java.lang.String r4 = "audio/aac"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto La9
            goto Ld8
        La9:
            java.lang.String r3 = "aac"
            return r3
        Lac:
            java.lang.String r4 = "audio/x-wav"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lb5
            goto Ld8
        Lb5:
            java.lang.String r3 = "wav"
            return r3
        Lb8:
            java.lang.String r4 = "audio/x-m4a"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lc1
            goto Ld8
        Lc1:
            java.lang.String r3 = "m4a"
            return r3
        Lc4:
            java.lang.String r4 = "audio/x-flac"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lcd
            goto Ld8
        Lcd:
            java.lang.String r3 = "flac"
            return r3
        Ld0:
            java.lang.String r4 = "application/ogg"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Ld9
        Ld8:
            return r2
        Ld9:
            java.lang.String r3 = "ogg"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.converter.AbilityInputConverter.audioExtHint(java.lang.String, java.lang.String):java.lang.String");
    }

    private final c.a convertAsrMultiFilesMixed(MixedContent mixedContent, String str) {
        List<Content> contents = mixedContent.getContents();
        ArrayList arrayList = new ArrayList();
        for (Object obj : contents) {
            if (obj instanceof FileContent) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            FileContent fileContent = (FileContent) obj2;
            String lowerCase = fileContent.getMimeType().toLowerCase(Locale.ROOT);
            g.e(lowerCase, "toLowerCase(...)");
            if (o.k0(lowerCase, "audio/", false) || fileContent.getMimeType().length() == 0) {
                arrayList2.add(obj2);
            }
        }
        if (arrayList2.isEmpty()) {
            throw new IllegalArgumentException("ASR multi-files MixedContent has no audio FileContent");
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj3 = arrayList2.get(i11);
            i11++;
            ParcelFileDescriptor pfd = ((FileContent) obj3).getPfd();
            if (pfd != null) {
                arrayList3.add(pfd);
            }
        }
        if (arrayList3.size() != arrayList2.size()) {
            throw new IllegalArgumentException("ASR multi-files requires ParcelFileDescriptor on each file");
        }
        ContentParams params = mixedContent.getParams();
        long[] multiFilesTimeOffsets = parseMultiFilesTimeOffsets(params != null ? params.getString("multi_files_time_offsets_csv", "") : null);
        AIEngineLogger.i(LogModule.ABILITY, TAG, "convertAsrMultiFilesMixed audioFiles=" + arrayList2.size());
        ArrayList arrayList4 = new ArrayList(m.Z(arrayList2, 10));
        int size3 = arrayList2.size();
        int i12 = 0;
        while (i12 < size3) {
            Object obj4 = arrayList2.get(i12);
            i12++;
            FileContent fileContent2 = (FileContent) obj4;
            arrayList4.add(audioExtHint(fileContent2.getPath(), fileContent2.getMimeType()));
        }
        return applyAsrOrchestration(new c.a(new short[0], 16000, null, null, AsrMultiFilesFileStore.INSTANCE.materializeFiles(arrayList3, multiFilesTimeOffsets, str, arrayList4), 492), mixedContent.getParams());
    }

    public static /* synthetic */ c.a convertAsrMultiFilesMixed$default(AbilityInputConverter abilityInputConverter, MixedContent mixedContent, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        return abilityInputConverter.convertAsrMultiFilesMixed(mixedContent, str);
    }

    private final c.a convertAudioContent(AudioContent audioContent, String str) {
        c.a aVar;
        Integer numValueOf;
        String string;
        ContentParams params = audioContent.getParams();
        String str2 = (params == null || (string = params.getString("audio_url", "")) == null || q.t0(string)) ? null : string;
        if (str2 != null) {
            short[] sArr = new short[0];
            int sampleRate = audioContent.getSampleRate();
            numValueOf = sampleRate > 0 ? Integer.valueOf(sampleRate) : null;
            aVar = new c.a(sArr, numValueOf != null ? numValueOf.intValue() : 16000, str2, null, null, 504);
        } else {
            int encoding = audioContent.getEncoding();
            if (encoding != 4) {
                switch (encoding) {
                    case 100:
                        short[] sArrPcmBytesToShorts = pcmBytesToShorts(d.X(new File(new String(audioContent.getAudioBytes(), a.f9106b))));
                        int sampleRate2 = audioContent.getSampleRate();
                        numValueOf = sampleRate2 > 0 ? Integer.valueOf(sampleRate2) : null;
                        aVar = new c.a(sArrPcmBytesToShorts, numValueOf != null ? numValueOf.intValue() : 16000, null, null, null, 508);
                        break;
                    case 101:
                        ParcelFileDescriptor pfd = audioContent.getPfd();
                        if (pfd == null) {
                            throw new IllegalArgumentException("AudioContent with ENCODING_FILE_DESCRIPTOR but pfd is null");
                        }
                        String str3 = ((c.b) kotlin.collections.a.G0(AsrMultiFilesFileStore.materializeFiles$default(AsrMultiFilesFileStore.INSTANCE, b1.P(pfd), null, str, null, 8, null))).f13394a;
                        short[] sArr2 = new short[0];
                        int sampleRate3 = audioContent.getSampleRate();
                        numValueOf = sampleRate3 > 0 ? Integer.valueOf(sampleRate3) : null;
                        aVar = new c.a(sArr2, numValueOf != null ? numValueOf.intValue() : 16000, null, str3, null, 500);
                        break;
                    case 102:
                        throw new IllegalArgumentException("ENCODING_AUDIO_URL but audio_url not found in ContentParams");
                    default:
                        aVar = new c.a(pcmBytesToShorts(audioContent.getAudioBytes()), audioContent.getSampleRate(), null, null, null, 508);
                        break;
                }
            } else {
                ByteBuffer byteBufferOrder = ByteBuffer.wrap(audioContent.getAudioBytes()).order(ByteOrder.LITTLE_ENDIAN);
                int length = audioContent.getAudioBytes().length / 4;
                short[] sArr3 = new short[length];
                for (int i10 = 0; i10 < length; i10++) {
                    sArr3[i10] = (short) (h.Z(byteBufferOrder.getFloat(), -1.0f, 1.0f) * AsrCloudWsSession.PCM_FULL_SCALE);
                }
                aVar = new c.a(sArr3, audioContent.getSampleRate(), null, null, null, 508);
            }
        }
        return applyAsrSseStreamExtras(applyVadExtras(applySlaExtras(applyCloudScene(applyAsrOrchestration(aVar, audioContent.getParams()), audioContent.getParams()), audioContent.getParams()), audioContent.getParams()), audioContent.getParams());
    }

    public static /* synthetic */ c.a convertAudioContent$default(AbilityInputConverter abilityInputConverter, AudioContent audioContent, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        return abilityInputConverter.convertAudioContent(audioContent, str);
    }

    private final Bitmap convertBGRAToBitmap(byte[] bArr, int i10, int i11) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        g.e(bitmapCreateBitmap, "createBitmap(...)");
        int i12 = i10 * i11;
        int[] iArr = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 4;
            int i15 = bArr[i14] & 255;
            int i16 = bArr[i14 + 1] & 255;
            iArr[i13] = ((bArr[i14 + 3] & 255) << 24) | ((bArr[i14 + 2] & 255) << 16) | (i16 << 8) | i15;
        }
        bitmapCreateBitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
        return bitmapCreateBitmap;
    }

    private final Bitmap convertBGRToBitmap(byte[] bArr, int i10, int i11) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        g.e(bitmapCreateBitmap, "createBitmap(...)");
        int i12 = i10 * i11;
        int[] iArr = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 3;
            iArr[i13] = ((bArr[i14 + 2] & 255) << 16) | (-16777216) | ((bArr[i14 + 1] & 255) << 8) | (bArr[i14] & 255);
        }
        bitmapCreateBitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
        return bitmapCreateBitmap;
    }

    private final c convertFileContent(FileContent fileContent, String str) throws IOException {
        String lowerCase = fileContent.getMimeType().toLowerCase(Locale.ROOT);
        g.e(lowerCase, "toLowerCase(...)");
        if (o.k0(lowerCase, "image/", false) || lowerCase.length() == 0) {
            Triple<Bitmap, byte[], Integer> tripleDecodeImageFromFileContent = decodeImageFromFileContent(fileContent, allowsDownsample(fileContent.getParams()));
            return visionOptionsFrom(fileContent.getParams(), new c.C0155c(tripleDecodeImageFromFileContent.f9995a, fileContent.getPath(), tripleDecodeImageFromFileContent.f9996b, tripleDecodeImageFromFileContent.f9997c.intValue(), 4056));
        }
        if (!o.k0(lowerCase, "audio/", false)) {
            return o.k0(lowerCase, "video/", false) ? new c.h(0L, fileContent.getPath(), "", 0) : new c.d(fileContent.getPath());
        }
        ParcelFileDescriptor pfd = fileContent.getPfd();
        if (pfd != null) {
            return new c.a(pcmBytesToShorts(readBytesFromPfd(pfd)), 16000, null, null, null, 508);
        }
        byte[] bytes = fileContent.getPath().getBytes(a.f9106b);
        g.e(bytes, "getBytes(...)");
        return convertAudioContent(new AudioContent(bytes, 0, 1, 100, null, 16, null), str);
    }

    public static /* synthetic */ c convertFileContent$default(AbilityInputConverter abilityInputConverter, FileContent fileContent, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        return abilityInputConverter.convertFileContent(fileContent, str);
    }

    private final c.C0155c convertImageContent(ImageContent imageContent) throws IOException, ErrnoException {
        byte[] bArr;
        Bitmap bitmap;
        Bitmap bitmapCopy;
        Bitmap bitmap2 = imageContent.getBitmap();
        if (bitmap2 != null) {
            return visionOptionsFrom(imageContent.getParams(), new c.C0155c(bitmap2, null, null, 0, 4094));
        }
        boolean zAllowsDownsample = allowsDownsample(imageContent.getParams());
        int iIntValue = 1;
        if (imageContent.getSharedMemory() != null) {
            SharedMemory sharedMemory = imageContent.getSharedMemory();
            g.c(sharedMemory);
            ByteBuffer byteBufferMapReadOnly = sharedMemory.mapReadOnly();
            g.e(byteBufferMapReadOnly, "mapReadOnly(...)");
            int iRemaining = byteBufferMapReadOnly.remaining();
            bArr = new byte[iRemaining];
            byteBufferMapReadOnly.get(bArr);
            SharedMemory.unmap(byteBufferMapReadOnly);
            sharedMemory.close();
            bitmapCopy = BitmapFactory.decodeByteArray(bArr, 0, iRemaining);
            if (bitmapCopy == null) {
                bitmapCopy = convertRawDataToBitmap(bArr, imageContent.getWidth(), imageContent.getHeight(), imageContent.getFormat());
            }
        } else {
            if (imageContent.getHwBuffer() == null) {
                if (imageContent.getShmFd() != null) {
                    ParcelFileDescriptor shmFd = imageContent.getShmFd();
                    g.c(shmFd);
                    Triple<Bitmap, byte[], Integer> tripleDecodeFdWithBytes = decodeFdWithBytes(shmFd, zAllowsDownsample);
                    Bitmap bitmap3 = tripleDecodeFdWithBytes.f9995a;
                    bArr = tripleDecodeFdWithBytes.f9996b;
                    iIntValue = tripleDecodeFdWithBytes.f9997c.intValue();
                    bitmap = bitmap3;
                    return visionOptionsFrom(imageContent.getParams(), new c.C0155c(bitmap, null, bArr, iIntValue, 4058));
                }
                throw new IllegalArgumentException("ImageContent has no valid data: hwBuffer=" + imageContent.getHwBuffer() + ", shmFd=" + imageContent.getShmFd() + ", sharedMemory=" + imageContent.getSharedMemory());
            }
            HardwareBuffer hwBuffer = imageContent.getHwBuffer();
            g.c(hwBuffer);
            bArr = null;
            Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hwBuffer, null);
            if (bitmapWrapHardwareBuffer == null) {
                throw new IllegalArgumentException("Failed to create Bitmap from HardwareBuffer");
            }
            bitmapCopy = bitmapWrapHardwareBuffer.copy(Bitmap.Config.ARGB_8888, false);
            g.c(bitmapCopy);
        }
        bitmap = bitmapCopy;
        return visionOptionsFrom(imageContent.getParams(), new c.C0155c(bitmap, null, bArr, iIntValue, 4058));
    }

    private final c convertMixedContent(MixedContent mixedContent, String str) {
        return isAsrMultiFilesMixed(mixedContent) ? convertAsrMultiFilesMixed(mixedContent, str) : convertMixedContentItems(mixedContent);
    }

    public static /* synthetic */ c convertMixedContent$default(AbilityInputConverter abilityInputConverter, MixedContent mixedContent, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        return abilityInputConverter.convertMixedContent(mixedContent, str);
    }

    private final c.e convertMixedContentItems(MixedContent mixedContent) {
        String strZ0;
        Set<String> setKeySet;
        String strZ02;
        Set<String> setKeys;
        List<Content> contents = mixedContent.getContents();
        ArrayList arrayList = new ArrayList(m.Z(contents, 10));
        Iterator<T> it = contents.iterator();
        while (it.hasNext()) {
            arrayList.add(InferenceInputConverter.DefaultImpls.convert$default(this, (Content) it.next(), null, 2, null));
        }
        Bundle bundleMixedExtrasFrom = mixedExtrasFrom(mixedContent);
        ContentParams params = mixedContent.getParams();
        boolean z = mixedContent.getParams() == null;
        ContentParams params2 = mixedContent.getParams();
        String str = "<null>";
        if (params2 == null || (setKeys = params2.keys()) == null || (strZ0 = kotlin.collections.a.z0(setKeys, ",", null, null, null, 62)) == null) {
            strZ0 = "<null>";
        }
        if (bundleMixedExtrasFrom != null && (setKeySet = bundleMixedExtrasFrom.keySet()) != null && (strZ02 = kotlin.collections.a.z0(setKeySet, ",", null, null, null, 62)) != null) {
            str = strZ02;
        }
        Log.w(TAG, "▶▶ [DIAG-EXTRAS] convertMixedContent: params=" + params + ", paramsIsNull=" + z + ", paramsKeys=" + strZ0 + ", extras=" + bundleMixedExtrasFrom + ", extrasKeys=" + str);
        return new c.e(arrayList, "", bundleMixedExtrasFrom);
    }

    private final Bitmap convertNV21ToBitmap(byte[] bArr, int i10, int i11) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i10, i11, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i10, i11), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        if (bitmapDecodeByteArray != null) {
            return bitmapDecodeByteArray;
        }
        throw new IllegalArgumentException("Failed to decode NV21 data");
    }

    private final Bitmap convertRGBAToBitmap(byte[] bArr, int i10, int i11) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        g.e(bitmapCreateBitmap, "createBitmap(...)");
        int i12 = i10 * i11;
        int[] iArr = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 4;
            int i15 = bArr[i14] & 255;
            int i16 = bArr[i14 + 1] & 255;
            iArr[i13] = ((bArr[i14 + 3] & 255) << 24) | (i15 << 16) | (i16 << 8) | (bArr[i14 + 2] & 255);
        }
        bitmapCreateBitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
        return bitmapCreateBitmap;
    }

    private final Bitmap convertRGBToBitmap(byte[] bArr, int i10, int i11) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        g.e(bitmapCreateBitmap, "createBitmap(...)");
        int i12 = i10 * i11;
        int[] iArr = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 3;
            iArr[i13] = (bArr[i14 + 2] & 255) | ((bArr[i14] & 255) << 16) | (-16777216) | ((bArr[i14 + 1] & 255) << 8);
        }
        bitmapCreateBitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
        return bitmapCreateBitmap;
    }

    private final Bitmap convertRawDataToBitmap(byte[] bArr, int i10, int i11, int i12) {
        switch (i12) {
            case 1:
                return convertRGBToBitmap(bArr, i10, i11);
            case 2:
                return convertRGBAToBitmap(bArr, i10, i11);
            case 3:
            case 4:
                return convertNV21ToBitmap(bArr, i10, i11);
            case 5:
                return convertBGRToBitmap(bArr, i10, i11);
            case 6:
                return convertBGRAToBitmap(bArr, i10, i11);
            default:
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (bitmapDecodeByteArray != null) {
                    return bitmapDecodeByteArray;
                }
                throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i12, "Cannot decode image data with format: "));
        }
    }

    private final c.h convertVideoContent(VideoContent videoContent) {
        if (videoContent.getShmFd() != null) {
            throw new UnsupportedOperationException("Video via SharedMemory is not supported yet; use FileContent with mimeType=video/*");
        }
        throw new IllegalArgumentException("VideoContent without file path; use FileContent(mimeType='video/*') for path-based video input");
    }

    private final Pair<Bitmap, Integer> decodeBytesWithSampleSize(byte[] bArr, boolean z, zb.a<String> aVar) {
        int iCalcSampleSize;
        Bitmap bitmapDecodeByteArray;
        if (z) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            iCalcSampleSize = BundleContentBridge.calcSampleSize(options.outWidth, options.outHeight);
        } else {
            iCalcSampleSize = 1;
        }
        if (iCalcSampleSize > 1) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options2.inSampleSize = iCalcSampleSize;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
        } else {
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        if (bitmapDecodeByteArray != null) {
            return new Pair<>(bitmapDecodeByteArray, Integer.valueOf(iCalcSampleSize));
        }
        throw new IllegalArgumentException(aVar.invoke());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[], java.io.Serializable] */
    private final Triple<Bitmap, byte[], Integer> decodeFdWithBytes(ParcelFileDescriptor parcelFileDescriptor, boolean z) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        try {
            ?? E = jd.b.E(fileInputStream);
            fileInputStream.close();
            parcelFileDescriptor.close();
            Pair<Bitmap, Integer> pairDecodeBytesWithSampleSize = decodeBytesWithSampleSize(E, z, new a9.a(8));
            return new Triple<>(pairDecodeBytesWithSampleSize.f9985a, E, Integer.valueOf(pairDecodeBytesWithSampleSize.f9986b.intValue()));
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String decodeFdWithBytes$lambda$3() {
        return "Cannot decode image from FileDescriptor";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [byte[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.io.Serializable] */
    private final Triple<Bitmap, byte[], Integer> decodeImageFromFileContent(FileContent fileContent, boolean z) throws IOException {
        ParcelFileDescriptor pfd = fileContent.getPfd();
        if (pfd == null) {
            File file = new File(fileContent.getPath());
            if (!file.canRead()) {
                throw new IllegalArgumentException(a0.a.k("Cannot decode image file: ", fileContent.getPath(), " — file may not exist or be inaccessible (EACCES). Use FileContent.fromPath() or FileContent.fromUri() to pass files from other app's private storage."));
            }
            ?? X = d.X(file);
            Pair<Bitmap, Integer> pairDecodeBytesWithSampleSize = decodeBytesWithSampleSize(X, z, new j0(fileContent, 3));
            return new Triple<>(pairDecodeBytesWithSampleSize.f9985a, X, Integer.valueOf(pairDecodeBytesWithSampleSize.f9986b.intValue()));
        }
        FileInputStream fileInputStream = new FileInputStream(pfd.getFileDescriptor());
        try {
            ?? E = jd.b.E(fileInputStream);
            fileInputStream.close();
            pfd.close();
            Pair<Bitmap, Integer> pairDecodeBytesWithSampleSize2 = decodeBytesWithSampleSize(E, z, new b6.g(fileContent, 3));
            return new Triple<>(pairDecodeBytesWithSampleSize2.f9985a, E, Integer.valueOf(pairDecodeBytesWithSampleSize2.f9986b.intValue()));
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String decodeImageFromFileContent$lambda$8$lambda$7(FileContent fileContent) {
        return ai.onnxruntime.a.k("Cannot decode image from FileDescriptor for: ", fileContent.getPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String decodeImageFromFileContent$lambda$9(FileContent fileContent) {
        return a0.a.k("Cannot decode image file: ", fileContent.getPath(), " (decode failed; unsupported format?)");
    }

    private final boolean isAsrMultiFilesMixed(MixedContent mixedContent) {
        List<Content> contents = mixedContent.getContents();
        ArrayList arrayList = new ArrayList();
        for (Object obj : contents) {
            if (obj instanceof FileContent) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            FileContent fileContent = (FileContent) obj2;
            String lowerCase = fileContent.getMimeType().toLowerCase(Locale.ROOT);
            g.e(lowerCase, "toLowerCase(...)");
            if (o.k0(lowerCase, "audio/", false) || fileContent.getMimeType().length() == 0) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            ContentParams params = mixedContent.getParams();
            if (params != null && params.containsKey("multi_files_mode") && params.getBoolean("multi_files_mode", false)) {
                return true;
            }
            if (arrayList2.size() > 1) {
                List<Content> contents2 = mixedContent.getContents();
                if (contents2 == null || !contents2.isEmpty()) {
                    Iterator<T> it = contents2.iterator();
                    while (it.hasNext()) {
                        if (!(((Content) it.next()) instanceof FileContent)) {
                        }
                    }
                }
                AIEngineLogger.d(LogModule.ABILITY, TAG, "isAsrMultiFilesMixed: detected by multi audio FileContent count=" + arrayList2.size());
                return true;
            }
            if (!arrayList2.isEmpty()) {
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj3 = arrayList2.get(i11);
                    i11++;
                    if (!o.k0(((FileContent) obj3).getPath(), "multi_file_", false)) {
                    }
                }
            }
            AIEngineLogger.d(LogModule.ABILITY, TAG, "isAsrMultiFilesMixed: detected by multi_file_* path prefix");
            return true;
        }
        return false;
    }

    private final Bundle mixedExtrasFrom(MixedContent mixedContent) {
        ContentParams params = mixedContent.getParams();
        if (params == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        boolean z = false;
        for (String str : params.keys()) {
            if (params.containsKey(str)) {
                int[] intArray = params.getIntArray(str);
                if (intArray != null) {
                    bundle.putIntArray(str, intArray);
                } else {
                    float[] floatArray = params.getFloatArray(str);
                    if (floatArray != null) {
                        bundle.putFloatArray(str, floatArray);
                    } else {
                        String string = params.getString(str, "A");
                        if (g.b(string, params.getString(str, "B"))) {
                            bundle.putString(str, string);
                        } else {
                            boolean z3 = params.getBoolean(str, false);
                            if (z3 == params.getBoolean(str, true)) {
                                bundle.putBoolean(str, z3);
                            } else {
                                int i10 = params.getInt(str, Integer.MIN_VALUE);
                                if (i10 == params.getInt(str, Integer.MAX_VALUE)) {
                                    bundle.putInt(str, i10);
                                } else {
                                    long j10 = params.getLong(str, Long.MIN_VALUE);
                                    if (j10 == params.getLong(str, Long.MAX_VALUE)) {
                                        bundle.putLong(str, j10);
                                    } else {
                                        float f8 = params.getFloat(str, 1.0f);
                                        if (f8 == params.getFloat(str, 2.0f)) {
                                            bundle.putFloat(str, f8);
                                        } else {
                                            double d8 = params.getDouble(str, 1.0d);
                                            if (d8 == params.getDouble(str, 2.0d)) {
                                                bundle.putDouble(str, d8);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                z = true;
            }
        }
        if (z) {
            return bundle;
        }
        return null;
    }

    private final b parseCloudScene(ContentParams contentParams) {
        if (contentParams == null) {
            return null;
        }
        String string = contentParams.getString("cloud.biz_code", "");
        if (q.t0(string)) {
            string = null;
        }
        String string2 = contentParams.getString("cloud.source_type", "");
        if (q.t0(string2)) {
            string2 = null;
        }
        if (string == null && string2 == null) {
            return null;
        }
        return new b(string, string2);
    }

    private final long[] parseMultiFilesTimeOffsets(String str) {
        if (str == null || q.t0(str)) {
            return null;
        }
        int i10 = 0;
        List listE0 = q.E0(str, new char[]{','});
        ArrayList arrayList = new ArrayList(m.Z(listE0, 10));
        Iterator it = listE0.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong(q.L0((String) it.next()).toString())));
        }
        long[] jArr = new long[arrayList.size()];
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            jArr[i10] = ((Number) obj).longValue();
            i10++;
        }
        return jArr;
    }

    private final short[] pcmBytesToShorts(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            sArr[i10] = (short) ((bArr[i11 + 1] << 8) | (bArr[i11] & 255));
        }
        return sArr;
    }

    private final byte[] readBytesFromPfd(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        try {
            byte[] bArrE = jd.b.E(fileInputStream);
            fileInputStream.close();
            parcelFileDescriptor.close();
            return bArrE;
        } finally {
        }
    }

    private final Bundle textExtrasFrom(ContentParams contentParams) {
        boolean z;
        if (contentParams == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        boolean z3 = true;
        if (contentParams.containsKey("execution_preference")) {
            bundle.putString("execution_preference", contentParams.getString("execution_preference", "auto"));
            z = true;
        } else {
            z = false;
        }
        if (contentParams.containsKey("task_priority")) {
            TaskPriority.a aVar = TaskPriority.f6396b;
            bundle.putInt("task_priority", contentParams.getInt("task_priority", 2));
            z = true;
        }
        if (contentParams.containsKey("tts.voice")) {
            bundle.putString("tts.voice", contentParams.getString("tts.voice", ""));
            z = true;
        }
        if (contentParams.containsKey("tts.instruction")) {
            bundle.putString("tts.instruction", contentParams.getString("tts.instruction", ""));
            z = true;
        }
        if (contentParams.containsKey("tts.speed")) {
            bundle.putFloat("tts.speed", contentParams.getFloat("tts.speed", 1.0f));
            z = true;
        }
        if (contentParams.containsKey("tts.volume")) {
            bundle.putFloat("tts.volume", contentParams.getFloat("tts.volume", 1.0f));
            z = true;
        }
        if (contentParams.containsKey("tts.sample_rate")) {
            bundle.putInt("tts.sample_rate", contentParams.getInt("tts.sample_rate", 0));
            z = true;
        }
        for (String str : contentParams.keys()) {
            if (o.k0(str, "sla.arg.", false)) {
                bundle.putString(str, contentParams.getString(str, ""));
                z = true;
            }
        }
        if (contentParams.containsKey("sla.executeAtomic")) {
            bundle.putBoolean("sla.executeAtomic", contentParams.getBoolean("sla.executeAtomic", true));
        } else {
            z3 = z;
        }
        if (z3) {
            return bundle;
        }
        return null;
    }

    private final c.C0155c visionOptionsFrom(ContentParams contentParams, c.C0155c c0155c) {
        Bundle bundle;
        if (contentParams == null) {
            return c0155c;
        }
        int[] intArray = contentParams.getIntArray(VisionParamKeys.POINTS_X);
        int[] intArray2 = contentParams.getIntArray(VisionParamKeys.POINTS_Y);
        Point[] pointArr = (intArray == null || intArray2 == null || intArray.length != 2 || intArray2.length != 2) ? null : new Point[]{new Point(intArray[0], intArray2[0]), new Point(intArray[1], intArray2[1])};
        int i10 = contentParams.getInt(VisionParamKeys.EXTEND_LEFT, 0);
        int i11 = contentParams.getInt(VisionParamKeys.EXTEND_TOP, 0);
        int i12 = contentParams.getInt(VisionParamKeys.EXTEND_RIGHT, 0);
        int i13 = contentParams.getInt(VisionParamKeys.EXTEND_BOTTOM, 0);
        Rect rect = (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? null : new Rect(i10, i11, i12, i13);
        if (contentParams.containsKey("task_priority")) {
            bundle = new Bundle();
            TaskPriority.a aVar = TaskPriority.f6396b;
            bundle.putInt("task_priority", contentParams.getInt("task_priority", 2));
        } else {
            bundle = c0155c.f13405l;
        }
        Bundle bundle2 = bundle;
        int i14 = contentParams.getInt(VisionParamKeys.SAMPLE_SIZE, 1);
        if (i14 < 1) {
            i14 = 1;
        }
        int i15 = c0155c.f13401g;
        if (i15 < 1) {
            i15 = 1;
        }
        int i16 = i14 * i15;
        int i17 = contentParams.getInt(VisionParamKeys.ROTATE_ANGLE, c0155c.f13399e);
        boolean z = !contentParams.getBoolean(VisionParamKeys.UNLIMITED_PROPORTION, false);
        boolean z3 = contentParams.getBoolean(VisionParamKeys.RETURN_IMAGE, true);
        if (pointArr == null) {
            pointArr = c0155c.f13400f;
        }
        Point[] pointArr2 = pointArr;
        if (rect == null) {
            rect = c0155c.f13403j;
        }
        long j10 = contentParams.getLong(VisionParamKeys.INFERENCE_SEED, c0155c.f13404k);
        Bitmap bitmap = c0155c.f13396b;
        String str = c0155c.f13397c;
        byte[] bArr = c0155c.f13398d;
        String id2 = c0155c.f13406m;
        g.f(bitmap, "bitmap");
        g.f(id2, "id");
        return new c.C0155c(bitmap, str, bArr, i17, pointArr2, i16, z, z3, rect, j10, bundle2, id2);
    }

    @Override // com.stepos.core.ability.converter.InferenceInputConverter
    public c convert(Content content, String requestId) throws IOException, ErrnoException {
        c fVar;
        g.f(content, "content");
        g.f(requestId, "requestId");
        if (content instanceof TextContent) {
            TextContent textContent = (TextContent) content;
            fVar = new c.g(textContent.getText(), textExtrasFrom(textContent.getParams()), 2);
        } else if (content instanceof ImageContent) {
            fVar = convertImageContent((ImageContent) content);
        } else if (content instanceof AudioContent) {
            fVar = convertAudioContent((AudioContent) content, requestId);
        } else if (content instanceof FileContent) {
            fVar = convertFileContent((FileContent) content, requestId);
        } else if (content instanceof VideoContent) {
            fVar = convertVideoContent((VideoContent) content);
        } else if (content instanceof MixedContent) {
            fVar = convertMixedContent((MixedContent) content, requestId);
        } else {
            if (!(content instanceof SessionRefContent)) {
                throw new IllegalArgumentException("Unsupported content type: ".concat(content.getClass().getSimpleName()));
            }
            SessionRefContent sessionRefContent = (SessionRefContent) content;
            fVar = new c.f(sessionRefContent.getName(), sessionRefContent.getPrompt(), sessionRefContent.getArgs());
        }
        String strExtractTraceId = TraceIdExtractorKt.extractTraceId(content.getParams());
        fVar.f13385a = strExtractTraceId;
        LogModule logModule = LogModule.ABILITY;
        if (strExtractTraceId == null) {
            strExtractTraceId = "<none>";
        }
        AIEngineLogger.i(logModule, TAG, ai.onnxruntime.a.l("[TRACE] convert injected: requestId=", requestId, ", traceId=", strExtractTraceId));
        return fVar;
    }

    @Override // com.stepos.core.ability.converter.InferenceInputConverter
    public void releaseTransient(String requestId) {
        g.f(requestId, "requestId");
        AsrMultiFilesFileStore.INSTANCE.releaseByRequestId(requestId);
    }
}
