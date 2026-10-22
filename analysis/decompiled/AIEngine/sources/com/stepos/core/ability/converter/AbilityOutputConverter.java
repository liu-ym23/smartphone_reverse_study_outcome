package com.stepos.core.ability.converter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import b6.i;
import com.stepos.base.data.ContourHierarchy;
import com.stepos.core.ability.speech.AsrAbility;
import com.stepos.core.ability.speech.AsrCloudWsSession;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.PrimitiveContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import dc.h;
import gc.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;
import mb.m;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityOutputConverter implements InferenceOutputConverter {
    private static final Companion Companion = new Companion(null);
    private static final int METADATA_INLINE_LIMIT_BYTES = 131072;
    private static final String TAG = "AbilityOutputConverter";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence convert$lambda$6(d.g face) {
        g.f(face, "face");
        StringBuilder sb2 = new StringBuilder();
        String str = face.f13440a;
        int i10 = face.f13441b;
        int i11 = face.f13442c;
        StringBuilder sbF = h0.e.f("{\"token\":\"", str, "\",\"x\":", i10, ",\"y\":");
        sbF.append(i11);
        sb2.append(sbF.toString());
        int i12 = face.f13443d;
        int i13 = face.f13444e;
        float f8 = face.f13445f;
        StringBuilder sbD = h0.e.d(i12, ",\"width\":", i13, ",\"height\":", ",\"score\":");
        sbD.append(f8);
        sb2.append(sbD.toString());
        Float f9 = face.f13446g;
        if (f9 != null) {
            sb2.append(",\"yaw\":" + f9.floatValue());
        }
        Float f10 = face.h;
        if (f10 != null) {
            sb2.append(",\"pitch\":" + f10.floatValue());
        }
        Float f11 = face.f13447i;
        if (f11 != null) {
            sb2.append(",\"roll\":" + f11.floatValue());
        }
        float[] fArr = face.f13448j;
        if (fArr != null && fArr.length == 10) {
            sb2.append(",\"landmarks\":[");
            for (int i14 = 0; i14 < 10; i14++) {
                if (i14 > 0) {
                    sb2.append(",");
                }
                sb2.append(fArr[i14]);
            }
            sb2.append("]");
        }
        sb2.append("}");
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence convert$lambda$9(d.j f8) {
        g.f(f8, "f");
        String strZ0 = a.z0(f8.f13454b, ",", null, null, null, 62);
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sbF = h0.e.f("{\"token\":\"", f8.f13453a, "\",\"dim\":", f8.f13455c, ",\"feature\":[");
        sbF.append(strZ0);
        sbF.append("]");
        sb2.append(sbF.toString());
        sb2.append("}");
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    private final TextContent convertAsrChunk(d.a aVar) {
        String str = aVar.f13429g;
        long j10 = aVar.f13425c;
        long j11 = aVar.f13424b;
        String str2 = aVar.f13423a;
        String str3 = str.length() > 0 ? aVar.f13429g : aVar.f13426d ? "asr.recognized" : "asr.delta";
        TextContent textContent = new TextContent(str2);
        ContentParams.Builder builderPutString = new ContentParams.Builder().putString("asr.event_type", str3).putInt("asr.segment.index", aVar.f13427e).putLong("asr.segment.start_ms", j11).putLong("asr.segment.end_ms", j10).putLong("start_time", j11).putLong("end_time", j10).putString(AsrAbility.EXTRA_SEGMENT_SPEAKER_ID, "");
        if (g.b(str3, "asr.delta")) {
            String str4 = aVar.f13428f;
            if (str4.length() != 0) {
                str2 = str4;
            }
            builderPutString.putString("asr.raw_delta", str2);
        }
        textContent.setParams(builderPutString.build());
        return textContent;
    }

    private final AudioContent convertAudioOutput(d.b bVar) {
        float[] fArr = bVar.f13430a;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(fArr.length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (float f8 : fArr) {
            byteBufferOrder.putShort((short) (h.Z(f8, -1.0f, 1.0f) * AsrCloudWsSession.PCM_FULL_SCALE));
        }
        byte[] bArrArray = byteBufferOrder.array();
        g.e(bArrArray, "array(...)");
        return new AudioContent(bArrArray, bVar.f13431b, bVar.f13432c, 2, null, 16, null);
    }

    private final TextContent convertClassificationOutput(d.c cVar) {
        cVar.getClass();
        a.z0(null, ",", null, null, new b6.e(22), 30);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final CharSequence convertClassificationOutput$lambda$22(Pair pair) {
        g.f(pair, "<destruct>");
        return "{\"label\":\"" + ((String) pair.f9985a) + "\",\"score\":" + ((Number) pair.f9986b).floatValue() + "}";
    }

    private final TextContent convertDetectionOutput(d.C0156d c0156d) {
        c0156d.getClass();
        a.z0(null, ",", null, null, new i(26), 30);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence convertDetectionOutput$lambda$21(v6.a box) {
        g.f(box, "box");
        return "{\"left\":0.0,\"top\":0.0,\"right\":0.0,\"bottom\":0.0,\"label\":\"null\",\"labelIndex\":0,\"confidence\":0.0}";
    }

    private final ImageContent convertImageDataOutput(d.l lVar) {
        return ImageContent.Companion.fromBytes(lVar.f13458a, lVar.f13459b, lVar.f13460c, mapImageFormat(lVar.f13461d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.Result$Failure] */
    private final ImageContent convertImageMattingOutput(d.m mVar) {
        ParcelFileDescriptor parcelFileDescriptorA;
        ArrayList arrayList = new ArrayList();
        List<List<Point>> list = mVar.f13464b;
        List<ContourHierarchy> list2 = mVar.f13465c;
        arrayList.add(Integer.valueOf(list.size()));
        for (List<Point> list3 : mVar.f13464b) {
            arrayList.add(Integer.valueOf(list3.size()));
            for (Point point : list3) {
                arrayList.add(Integer.valueOf(point.x));
                arrayList.add(Integer.valueOf(point.y));
            }
        }
        int[] iArrN0 = a.N0(arrayList);
        int size = list2.size() * 4;
        int[] iArr = new int[size];
        Iterator it = list2.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                Bitmap bitmap = mVar.f13463a;
                ImageContent imageContentFromBitmap$default = bitmap != null ? ImageContent.Companion.fromBitmap$default(ImageContent.Companion, bitmap, 0, 0, 0, Integer.MAX_VALUE, 14, null) : new ImageContent(null, null, 0L, 0, 0, 0, 0, null, null, 511, null);
                ContentParams.Builder builder = new ContentParams.Builder();
                Rect rect = mVar.f13467e;
                ContentParams.Builder builderPutInt = builder.putIntArray("mat_region", new int[]{rect.left, rect.top, rect.right, rect.bottom}).putFloat("mat_proportion", mVar.f13466d).putInt("mat_sample_size", mVar.f13468f);
                int length = (iArrN0.length + size) * 4;
                if (length > METADATA_INLINE_LIMIT_BYTES) {
                    try {
                        parcelFileDescriptorA = writeIntArraysToFd(iArrN0, iArr);
                    } catch (Throwable th) {
                        parcelFileDescriptorA = c.a(th);
                    }
                    Throwable thB = Result.b(parcelFileDescriptorA);
                    if (thB != null) {
                        AIEngineLogger.w(LogModule.ABILITY, TAG, a0.a.g("matting metadata offload failed (", length, "B), falling back to inline: ", thB.getMessage()));
                    }
                    parcelFileDescriptor = parcelFileDescriptorA instanceof Result.Failure ? null : parcelFileDescriptorA;
                }
                ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptor;
                if (parcelFileDescriptor != null) {
                    LogModule logModule = LogModule.ABILITY;
                    StringBuilder sbD = h0.e.d(length, "matting metadata offloaded to fd: ", iArrN0.length, "B, contourInts=", ", hierInts=");
                    sbD.append(size);
                    AIEngineLogger.i(logModule, TAG, sbD.toString());
                    builderPutInt.putInt("mat_contours_ints", iArrN0.length).putInt("mat_hierarchies_ints", size);
                    imageContentFromBitmap$default = new ImageContent(imageContentFromBitmap$default.getHwBuffer(), parcelFileDescriptor, imageContentFromBitmap$default.getShmSize(), imageContentFromBitmap$default.getWidth(), imageContentFromBitmap$default.getHeight(), imageContentFromBitmap$default.getFormat(), imageContentFromBitmap$default.getRotation(), imageContentFromBitmap$default.getBitmap(), imageContentFromBitmap$default.getSharedMemory());
                } else {
                    builderPutInt.putIntArray("mat_contours", iArrN0).putIntArray("mat_hierarchies", iArr);
                }
                imageContentFromBitmap$default.setParams(builderPutInt.build());
                return imageContentFromBitmap$default;
            }
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                m.f0();
                throw null;
            }
            ContourHierarchy contourHierarchy = (ContourHierarchy) next;
            int i12 = i10 * 4;
            iArr[i12] = contourHierarchy.getNext();
            iArr[i12 + 1] = contourHierarchy.getPrevious();
            iArr[i12 + 2] = contourHierarchy.getFirstChild();
            iArr[i12 + 3] = contourHierarchy.getParent();
            i10 = i11;
        }
    }

    private final ImageContent convertInteractiveSegmentOutput(d.o oVar) {
        return ImageContent.Companion.fromBitmap$default(ImageContent.Companion, oVar.f13477a, 0, 0, 0, Integer.MAX_VALUE, 14, null);
    }

    private final TextContent convertPrivacyClassifyOutput(d.p pVar) {
        String strI0 = l.i0(pVar.f13483c);
        String strI02 = l.i0(pVar.f13484d);
        int i10 = pVar.f13481a;
        boolean z = pVar.f13482b;
        int i11 = pVar.f13485e;
        StringBuilder sb2 = new StringBuilder("{\"type\":\"privacy_classify\",\"predictedClass\":");
        sb2.append(i10);
        sb2.append(",\"label\":");
        sb2.append(z);
        sb2.append(",\"classCount\":");
        h0.e.h(i11, ",\"logits\":[", strI0, "],\"probs\":[", sb2);
        return new TextContent(ai.onnxruntime.a.o(sb2, strI02, "]}"));
    }

    private final void copyBundleToParams(Bundle bundle, ContentParams.Builder builder) {
        for (String str : bundle.keySet()) {
            g.c(str);
            if (o.e0(str, "_ms", false) || str.equals("start_time") || str.equals("end_time")) {
                builder.putLong(str, bundle.getLong(str));
            } else {
                Object obj = bundle.get(str);
                if (obj instanceof Long) {
                    builder.putLong(str, ((Number) obj).longValue());
                } else if (obj instanceof Integer) {
                    builder.putInt(str, ((Number) obj).intValue());
                } else if (obj instanceof String) {
                    builder.putString(str, (String) obj);
                } else if (obj instanceof Float) {
                    builder.putFloat(str, ((Number) obj).floatValue());
                } else if (obj instanceof Double) {
                    builder.putDouble(str, ((Number) obj).doubleValue());
                } else if (obj instanceof Boolean) {
                    builder.putBoolean(str, ((Boolean) obj).booleanValue());
                }
            }
        }
    }

    private final int mapImageFormat(int i10) {
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                if (i10 == 3) {
                    return 3;
                }
                if (i10 != 4) {
                    return i10 != 5 ? 2 : 6;
                }
                return 5;
            }
        }
        return i11;
    }

    private final ParcelFileDescriptor writeIntArraysToFd(int[]... iArr) throws IOException {
        Context context = l7.a.f10344a;
        if (context == null) {
            throw new IllegalStateException("ContextHolder must be initialized before use!");
        }
        File fileCreateTempFile = File.createTempFile("matting_meta", ".bin", context.getCacheDir());
        try {
            int length = 0;
            for (int[] iArr2 : iArr) {
                length += iArr2.length;
            }
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(length * 4).order(ByteOrder.LITTLE_ENDIAN);
            for (int[] iArr3 : iArr) {
                for (int i10 : iArr3) {
                    byteBufferOrder.putInt(i10);
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                fileOutputStream.write(byteBufferOrder.array());
                n nVar = n.f10413a;
                fileOutputStream.close();
                ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(fileCreateTempFile, 268435456);
                g.e(parcelFileDescriptorOpen, "open(...)");
                fileCreateTempFile.delete();
                return parcelFileDescriptorOpen;
            } finally {
            }
        } catch (Throwable th) {
            fileCreateTempFile.delete();
            throw th;
        }
    }

    @Override // com.stepos.core.ability.converter.InferenceOutputConverter
    public Content convert(d output) {
        g.f(output, "output");
        if (output instanceof d.a) {
            return convertAsrChunk((d.a) output);
        }
        if (output instanceof d.q) {
            d.q qVar = (d.q) output;
            Bundle bundle = qVar.f13489c;
            String str = qVar.f13488b;
            TextContent textContent = new TextContent(qVar.f13487a);
            if (str.length() > 0 || bundle != null) {
                ContentParams.Builder builder = new ContentParams.Builder();
                if (str.length() > 0) {
                    builder.putString("asr.event_type", str);
                }
                if (bundle != null) {
                    copyBundleToParams(bundle, builder);
                }
                textContent.setParams(builder.build());
            }
            return textContent;
        }
        if (output instanceof d.r) {
            a.z0(null, ",", "[", "]", null, 56);
            throw null;
        }
        if (output instanceof d.e) {
            return PrimitiveContent.Companion.ofFloatArray(((d.e) output).f13435a);
        }
        if (output instanceof d.C0156d) {
            return convertDetectionOutput((d.C0156d) output);
        }
        if (output instanceof d.c) {
            return convertClassificationOutput((d.c) output);
        }
        if (output instanceof d.p) {
            return convertPrivacyClassifyOutput((d.p) output);
        }
        if (output instanceof d.b) {
            return convertAudioOutput((d.b) output);
        }
        if (output instanceof d.l) {
            return convertImageDataOutput((d.l) output);
        }
        if (output instanceof d.m) {
            return convertImageMattingOutput((d.m) output);
        }
        if (output instanceof d.o) {
            return convertInteractiveSegmentOutput((d.o) output);
        }
        if (output instanceof d.h) {
            return new TextContent(a0.a.k("{\"type\":\"face_detect\",\"faces\":[", a.z0(((d.h) output).f13449a, ",", null, null, new i(25), 30), "]}"));
        }
        if (output instanceof d.i) {
            return new TextContent(a0.a.k("{\"type\":\"face_embed\",\"features\":[", a.z0(((d.i) output).f13451a, ",", null, null, new b6.e(23), 30), "]}"));
        }
        if (!(output instanceof d.k)) {
            return output instanceof d.f ? new TextContent(a0.a.k("{\"type\":\"error\",\"message\":\"", ((d.f) output).f13437a, "\"}")) : new TextContent("{\"type\":\"unknown\"}");
        }
        return new TextContent("{\"type\":\"face_quality\",\"quality\":" + ((d.k) output).f13456a + "}");
    }
}
