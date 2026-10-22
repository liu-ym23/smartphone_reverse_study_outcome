package com.obric.network.request.intelligentvoice;

import android.os.HandlerThread;
import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.network.NetWorkClient;
import com.obric.network.request.data.DataResponse;
import com.obric.utils.DeviceIdPrivacy;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntelligentVoiceHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001>B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0081\u0001\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u001a0\u001f2O\u0010!\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001a0\"J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0015\u0010*\u001a\u00020+2\b\u0010%\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010,Jy\u0010-\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0/2O\u0010!\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001a0\"Jm\u00100\u001a\u00020\u001a2\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020\u001a0\u001f2O\u0010!\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001a0\"J\u0016\u00102\u001a\u00020\u001d2\f\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u000104H\u0002J\u0095\u0001\u00105\u001a\u00020\u001a2\b\u00106\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020\u001a0\u001f2O\u0010!\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001a0\"Ju\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010=\u0012\u0004\u0012\u00020\u001a0\u001f2O\u0010!\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001a0\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/obric/network/request/intelligentvoice/IntelligentVoiceHelper;", "", "()V", "BASE_URL", "", "DEFAULT_SOUND_VERSION", "NETWORK_ERR_SOUND_COPY_FAILED", "", "NETWORK_ERR_SOUND_NAME_REVIEW_FAILED", "NETWORK_ERR_SOUND_VOICE_REVIEW_FAILED", "TAG", "intelligentVoiceHandlerThread", "Landroid/os/HandlerThread;", "getIntelligentVoiceHandlerThread", "()Landroid/os/HandlerThread;", "intelligentVoiceHandlerThread$delegate", "Lkotlin/Lazy;", "netWorkClient", "Lcom/obric/network/NetWorkClient;", "service", "Lcom/obric/network/request/intelligentvoice/IntelligentVoiceAPI;", "createMultiPartBody", "Lokhttp3/MultipartBody;", "file", "Ljava/io/File;", "deleteSound", "", "soundId", "deleteAll", "", "success", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "failure", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", AccountConst.KEY_ERROR_CODE, AccountConst.KEY_ERROR_MSG, "", NotificationCompat.CATEGORY_ERROR, "getContactType", "getSoundCopyFailureType", "Lcom/obric/network/request/intelligentvoice/IntelligentVoiceHelper$SoundCopyFailureType;", "(Ljava/lang/Integer;)Lcom/obric/network/request/intelligentvoice/IntelligentVoiceHelper$SoundCopyFailureType;", "getSoundCopyText", "empty", "Lkotlin/Function0;", "getSoundList", "Lcom/obric/network/request/intelligentvoice/SoundListGetResponseBody;", "isRequestSuccess", ApmTrafficStats.TTNET_RESPONSE, "Lcom/obric/network/request/data/DataResponse;", "soundCopy", "fileUrl", "soundName", "speakerId", "promptText", "Lcom/obric/network/request/intelligentvoice/SoundCopyResponseBody;", "uploadFile", Params.FILE_PATH, "Lcom/obric/network/request/intelligentvoice/SoundFailResponseBody;", "SoundCopyFailureType", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentVoiceHelper {
    private static final String BASE_URL = "https://ocean-secret.obriccloud.com";
    public static final String DEFAULT_SOUND_VERSION = "2";
    public static final IntelligentVoiceHelper INSTANCE = null;
    public static final int NETWORK_ERR_SOUND_COPY_FAILED = 50003;
    public static final int NETWORK_ERR_SOUND_NAME_REVIEW_FAILED = 50004;
    public static final int NETWORK_ERR_SOUND_VOICE_REVIEW_FAILED = 50005;
    public static final String TAG = "IntelligentVoiceHelper";
    private static final Lazy intelligentVoiceHandlerThread$delegate = null;
    private static NetWorkClient netWorkClient;
    private static IntelligentVoiceAPI service;

    /* JADX INFO: compiled from: IntelligentVoiceHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/network/request/intelligentvoice/IntelligentVoiceHelper$SoundCopyFailureType;", "", "(Ljava/lang/String;I)V", "COPY_FAILED", "NAME_REVIEW_REJECTED", "VOICE_REVIEW_REJECTED", "UNKNOWN", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum SoundCopyFailureType extends Enum<SoundCopyFailureType> {
        private static final /* synthetic */ SoundCopyFailureType[] $VALUES = null;
        public static final SoundCopyFailureType COPY_FAILED = null;
        public static final SoundCopyFailureType NAME_REVIEW_REJECTED = null;
        public static final SoundCopyFailureType UNKNOWN = null;
        public static final SoundCopyFailureType VOICE_REVIEW_REJECTED = null;

        private static final /* synthetic */ SoundCopyFailureType[] $values() {
            return new SoundCopyFailureType[]{COPY_FAILED, NAME_REVIEW_REJECTED, VOICE_REVIEW_REJECTED, UNKNOWN};
        }

        public static SoundCopyFailureType valueOf(String r1) {
            return (SoundCopyFailureType) Enum.valueOf(SoundCopyFailureType.class, r1);
        }

        public static SoundCopyFailureType[] values() {
            return (SoundCopyFailureType[]) $VALUES.clone();
        }

        private SoundCopyFailureType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            COPY_FAILED = new SoundCopyFailureType("COPY_FAILED", 0);
            NAME_REVIEW_REJECTED = new SoundCopyFailureType("NAME_REVIEW_REJECTED", 1);
            VOICE_REVIEW_REJECTED = new SoundCopyFailureType("VOICE_REVIEW_REJECTED", 2);
            UNKNOWN = new SoundCopyFailureType("UNKNOWN", 3);
            $VALUES = $values();
        }
    }

    private IntelligentVoiceHelper() {
    }

    public static final /* synthetic */ NetWorkClient access$getNetWorkClient$p() {
        return netWorkClient;
    }

    public static final /* synthetic */ IntelligentVoiceAPI access$getService$p() {
        return service;
    }

    public static final /* synthetic */ boolean access$isRequestSuccess(IntelligentVoiceHelper r0, DataResponse r1) {
        return r0.isRequestSuccess(r1);
    }

    static {
        IntelligentVoiceHelper r0 = new IntelligentVoiceHelper();
        INSTANCE = r0;
        intelligentVoiceHandlerThread$delegate = LazyKt.lazy(IntelligentVoiceHelper$intelligentVoiceHandlerThread$2.INSTANCE);
        List r1 = CollectionsKt.listOf(new IntelligentVoiceHeaderInterceptor());
        NetWorkClient r2 = new NetWorkClient(BASE_URL, r0.getIntelligentVoiceHandlerThread(), r1);
        netWorkClient = r2;
        service = (IntelligentVoiceAPI) r2.getRetrofit().create(IntelligentVoiceAPI.class);
    }

    private final HandlerThread getIntelligentVoiceHandlerThread() {
        return (HandlerThread) intelligentVoiceHandlerThread$delegate.getValue();
    }

    public final SoundCopyFailureType getSoundCopyFailureType(Integer r2) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r2 == null) goto L18;
        if (r2.intValue() != 50005) goto L18;
        return SoundCopyFailureType.VOICE_REVIEW_REJECTED;
    L18:
        return SoundCopyFailureType.UNKNOWN;
    L10:
        if (r2.intValue() != 50004) goto L12;
        return SoundCopyFailureType.NAME_REVIEW_REJECTED;
    L5:
        if (r2.intValue() != 50003) goto L7;
        return SoundCopyFailureType.COPY_FAILED;
    }

    public final void getSoundList(final Function1<? super SoundListGetResponseBody, Unit> r2, final Function3<? super Integer, ? super String, ? super Throwable, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "success");
        Intrinsics.checkNotNullParameter(r3, "failure");
        DeviceIdPrivacy.INSTANCE.getIdAttestation(new C03081(r3, r2));
    }

    public final void getSoundCopyText(final Function1<? super String, Unit> r2, final Function0<Unit> r3, final Function3<? super Integer, ? super String, ? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "success");
        Intrinsics.checkNotNullParameter(r3, "empty");
        Intrinsics.checkNotNullParameter(r4, "failure");
        DeviceIdPrivacy.INSTANCE.getIdAttestation(new C03071(r4, r2, r3));
    }

    public static /* synthetic */ void deleteSound$default(IntelligentVoiceHelper r0, String r1, boolean r2, Function1 r3, Function3 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.deleteSound(r1, r2, r3, r4);
    }

    public final void deleteSound(final String r2, final boolean r3, final Function1<? super JSONObject, Unit> r4, final Function3<? super Integer, ? super String, ? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "success");
        Intrinsics.checkNotNullParameter(r5, "failure");
        DeviceIdPrivacy.INSTANCE.getIdAttestation(new AnonymousClass1(r2, r3, r5, r4));
    }

    public static /* synthetic */ void soundCopy$default(IntelligentVoiceHelper r7, String r8, String r9, String r10, String r11, Function1 r12, Function3 r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = null;
    L5:
        r7.soundCopy(r8, r9, r10, r11, r12, r13);
    }

    public final void soundCopy(final String r9, final String r10, final String r11, final String r12, final Function1<? super SoundCopyResponseBody, Unit> r13, final Function3<? super Integer, ? super String, ? super Throwable, Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "soundName");
        Intrinsics.checkNotNullParameter(r13, "success");
        Intrinsics.checkNotNullParameter(r14, "failure");
        DeviceIdPrivacy.INSTANCE.getIdAttestation(new C03091(r9, r10, r11, r12, r14, r13));
    }

    public final void uploadFile(String r4, final Function1<? super SoundFailResponseBody, Unit> r5, final Function3<? super Integer, ? super String, ? super Throwable, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, Params.FILE_PATH);
        Intrinsics.checkNotNullParameter(r5, "success");
        Intrinsics.checkNotNullParameter(r6, "failure");
        final File r0 = new File(r4);
        if (r0.exists() == true) goto L6;
        r6.invoke(null, null, new IOException("File not found: " + r4));
        return;
    L6:
        final MultipartBody r3 = createMultiPartBody(r0);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "uploadFile: " + r0.length() + ", data " + r3);
        DeviceIdPrivacy.INSTANCE.getIdAttestation(new C03101(r0, r3, r6, r5));
    }

    private final boolean isRequestSuccess(DataResponse<?> r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getCode() != 200) goto L9;
        return true;
    L9:
        return false;
    }

    private final String getContactType(File r1) {
        String r0 = FilesKt.getExtension(r1).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r0, "toLowerCase(...)");
        switch(r0.hashCode()) {
            case 105441: goto L25;
            case 106458: goto L21;
            case 108272: goto L17;
            case 111145: goto L13;
            case 117484: goto L9;
            case 3268712: goto L6;
            default: goto L28;
        };
    L28:
        return "application/octet-stream";
    L6:
        if (r0.equals("jpeg") == false) goto L28;
    L27:
        return "image/jpeg";
    L9:
        if (r0.equals("wav") == false) goto L28;
        return "audio/wav";
    L13:
        if (r0.equals("png") == false) goto L28;
        return "image/png";
    L17:
        if (r0.equals("mp3") == false) goto L28;
        return "audio/mpeg";
    L21:
        if (r0.equals("m4a") == false) goto L28;
        return "audio/mp4";
    L25:
        if (r0.equals("jpg") == true) goto L27;
        goto L27
    }

    private final MultipartBody createMultiPartBody(File r3) {
        MultipartBody.Builder r0 = new MultipartBody.Builder();
        RequestBody r2 = RequestBody.create(MediaType.parse(getContactType(r3)), r3);
        Intrinsics.checkNotNullExpressionValue(r2, "create(\n            Medi…           file\n        )");
        r0.addFormDataPart("file", r3.getName(), r2);
        r0.setType(MultipartBody.FORM);
        MultipartBody r4 = r0.build();
        Intrinsics.checkNotNullExpressionValue(r4, "builder.build()");
        return r4;
    }
}
