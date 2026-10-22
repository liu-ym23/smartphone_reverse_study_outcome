package com.obric.capabilitykit.common.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.CardView;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.RemoteCard;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.p;
import d.o.o;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class IntentResult<E> implements Parcelable {
    public static final b CREATOR = null;
    private static final int FLAG_INQUIRE_FURTHER = 1;
    private static final int FLAG_NEED_TO_SUMMARIZE = 2;
    public static final String KEY_ENTITY_FALLBACK_JSON = "__entity_fallback_json_v1__";
    public static final String KEY_ENTITY_FALLBACK_TYPE = "__entity_fallback_type_v1__";
    private static final int PARCELABLE = 0;
    private static final int PARCELABLE_ARRAY = 1;
    private static final String TAG = "IntentResult";
    private static final f<Gson> sGson$delegate = null;
    private String details;
    private E entity;
    private transient boolean entityWrittenToFallbackOnly;
    private ConcurrentHashMap<String, String> ext;
    private FloatingIntentParams floatingIntentParams;
    private boolean inquireFurther;
    private Intent intent;
    public boolean isFinal;
    private boolean needToSummarize;
    public RemoteCard remoteCard;
    private int ret;
    private int uiType;
    private CardView view;

    public static final class a extends p implements d.h.a.a<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32056a = null;

        static {
            f32056a = new a();
        }

        public a() {
            super(0);
        }

        public final Gson a() {
            return new Gson();
        }

        @Override // d.h.a.a
        public /* synthetic */ Gson invoke() {
            return a();
        }
    }

    public static final class b implements Parcelable.Creator<IntentResult<?>> {
        private b() {
        }

        public /* synthetic */ b(h r1) {
            this();
        }

        private final Gson a() {
            return (Gson) ZeusTransformUtils.preCheckCast(IntentResult.access$getSGson$delegate$cp().b(), Gson.class, "com.obric.aiagent.plugin");
        }

        public static final /* synthetic */ Gson a(b r0) {
            return r0.a();
        }

        private final Object a(ConcurrentHashMap<String, String> r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            String r2 = (String) ZeusTransformUtils.preCheckCast(r8.get(IntentResult.KEY_ENTITY_FALLBACK_JSON), String.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L40;
            boolean r5 = true;
            if (r2.length() <= 0) goto L10;
            boolean r3 = true;
        L11:
            if (r3 == true) goto L14;
            r2 = null;
        L14:
            if (r2 == null) goto L43;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8.get(IntentResult.KEY_ENTITY_FALLBACK_TYPE), String.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L19;
            return null;
        L19:
            if (r9.length() > 0) goto L22;
            r5 = false;
        L22:
            if (r5 == true) goto L25;
            r9 = null;
        L25:
            if (r9 != null) goto L39;
            return null;
        L39:
            boolean r4 = o.c(r9, "[]", false, 2, null);     // Catch: Throwable -> L36
            if (r4 == false) goto L31;
            r9 = o.b(r9, "[]");     // Catch: Throwable -> L36
        L31:
            Class r10 = ZeusTransformUtils.forName(r9, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
            if (r4 == false) goto L34;
            Object r7 = a().fromJson(r2, Array.newInstance(r10, 0).getClass());     // Catch: Throwable -> L36
        L42:
            return r7;
        L34:
            r7 = a().fromJson(r2, r10);     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            INVOKESTATIC_com_obric_capabilitykit_common_intent_IntentResult$b_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(IntentResult.TAG, "resolveEntityFromFallback failed (silent): " + th.getMessage());
            return null;
        L43:
            return null;
        L10:
            r3 = false;
            goto L11
        L40:
            return null;
        }

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.w(r0, r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [android.os.Parcelable] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v5, types: [android.os.Parcelable[]] */
        public IntentResult<?> a(Parcel r17) {
            int r1 = r17.readInt();
            d.h.b.o.e(r17, "parcel");
            int r4 = r17.readInt();
            if (r17.readInt() != 1) goto L7;
            int r2 = r17.readInt();
            ?? r5 = new Parcelable[r2];
            int r6 = 0;
        L5:
            if (r6 >= r2) goto L8;
            r5[r6] = r17.readParcelable(IntentResult.class.getClassLoader());
            r6 = r6 + 1;
        L8:
            CardView r7 = (CardView) ZeusTransformUtils.preCheckCast(r17.readParcelable(CardView.class.getClassLoader()), CardView.class, "com.obric.aiagent.plugin");
            String r8 = r17.readString();
            Intent r11 = (Intent) ZeusTransformUtils.preCheckCast(r17.readParcelable(Intent.class.getClassLoader()), Intent.class, "com.obric.aiagent.plugin");
            FloatingIntentParams r12 = (FloatingIntentParams) ZeusTransformUtils.preCheckCast(r17.readParcelable(FloatingIntentParams.class.getClassLoader()), FloatingIntentParams.class, "com.obric.aiagent.plugin");
            int r3 = r17.readInt();
            if ((r3 & 1) == 0) goto L11;
            boolean r9 = true;
        L13:
            if ((r3 & 2) == 0) goto L15;
            boolean r10 = true;
        L16:
            int r13 = r17.readInt();
            Serializable r14 = r17.readSerializable();
            if (ZeusTransformUtils.instanceOf(r14, ConcurrentHashMap.class) == false) goto L19;
            ConcurrentHashMap<String, String> r15 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r14, ConcurrentHashMap.class, "com.obric.aiagent.plugin");
        L20:
            if (r5 != 0) goto L22;
        L29:
            r5 = a(r15);
        L30:
            IntentResult<?> r16 = r3;
            IntentResult<?> r18 = new IntentResult(r4, r5, r7, r8, r9, r10, r13, r11, r12, r15);
            int r19 = Math.min(r1, 2);
            ClassLoader r20 = b.class.getClassLoader();
            int r21 = 1;
        L31:
            if (r21 > r19) goto L44;
            if (r21 != 1) goto L38;
            Object r22 = com.obric.a.a.b(r17, r20);
            if (r22 == null) goto L37;
            IntentResult<?> r23 = r16;
            r23.isFinal = ((Boolean) ZeusTransformUtils.preCheckCast(r22, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L43:
            r21 = r21 + 1;
            r16 = r23;
            goto L31
        L37:
            r23 = r16;
            goto L43
        L38:
            r23 = r16;
            if (r21 != 2) goto L43;
            Object r24 = com.obric.a.a.b(r17, r20);
            if (r24 == null) goto L43;
            r23.remoteCard = (RemoteCard) ZeusTransformUtils.preCheckCast(r24, RemoteCard.class, "com.obric.aiagent.plugin");
            goto L43
        L44:
            IntentResult<?> r25 = r16;
        L45:
            if (r21 > r1) goto L47;
            com.obric.a.a.a(r17, r20);
            r21 = r21 + 1;
            goto L45
        L47:
            return r25;
        L22:
            if ((r5 instanceof Object[]) == false) goto L30;
            if (((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.aiagent.plugin")).length != 0) goto L26;
            boolean r26 = true;
        L27:
            if (r26 == true) goto L29;
        L26:
            r26 = false;
            goto L27
        L19:
            r15 = null;
            goto L20
        L15:
            r10 = false;
            goto L16
        L11:
            r9 = false;
            goto L13
        L7:
            r5 = r17.readParcelable(IntentResult.class.getClassLoader());
            goto L8
        }

        public IntentResult<?>[] a(int r1) {
            return new IntentResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentResult<?> createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentResult<?>[] newArray(int r1) {
            return a(r1);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_capabilitykit_common_intent_IntentResult$b_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    static {
        CREATOR = new b(null);
        sGson$delegate = g.a(a.f32056a);
    }

    public IntentResult() {
        this(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    public IntentResult(int r1, E r2, CardView r3, String r4, boolean r5, boolean r6, int r7, Intent r8, FloatingIntentParams r9, ConcurrentHashMap<String, String> r10) {
        this.ret = r1;
        this.view = r3;
        this.details = r4;
        this.inquireFurther = r5;
        this.needToSummarize = r6;
        this.uiType = r7;
        this.intent = r8;
        this.floatingIntentParams = r9;
        this.ext = r10;
        this.isFinal = true;
        setEntity(r2);
    }

    public /* synthetic */ IntentResult(int r4, Object r5, CardView r6, String r7, boolean r8, boolean r9, int r10, Intent r11, FloatingIntentParams r12, ConcurrentHashMap r13, int r14, h r15) {
        if ((r14 & 1) == 0) goto L6;
        r4 = 1;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r8 = false;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r9 = false;
    L21:
        if ((r14 & 64) == 0) goto L24;
        r10 = 1;
    L24:
        if ((r14 & 128) == 0) goto L27;
        r11 = null;
    L27:
        if ((r14 & 256) == 0) goto L30;
        r12 = null;
    L30:
        if ((r14 & 512) == 0) goto L32;
        r13 = null;
    L32:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static final /* synthetic */ f access$getSGson$delegate$cp() {
        return sGson$delegate;
    }

    public static /* synthetic */ void getView$annotations() {
    }

    private final boolean isParcelableArray() {
        return this.entity instanceof Object[];
    }

    public static /* synthetic */ void putEntityFallback$default(IntentResult r1, Object r2, String r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.putEntityFallback(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getDetails() {
        return this.details;
    }

    public final E getEntity() {
        return this.entity;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final FloatingIntentParams getFloatingIntentParams() {
        return this.floatingIntentParams;
    }

    public final boolean getInquireFurther() {
        return this.inquireFurther;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final boolean getNeedToSummarize() {
        return this.needToSummarize;
    }

    public final RemoteCard getRemoteCard() {
        return this.remoteCard;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final CardView getView() {
        return this.view;
    }

    public final boolean isFinal() {
        return this.isFinal;
    }

    public final void putEntityFallback(Object r7) {
        putEntityFallback$default(this, r7, null, null, 6, null);
    }

    public final void putEntityFallback(Object r7, String r8) {
        putEntityFallback$default(this, r7, r8, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putEntityFallback(Object r10, String r11, Boolean r12) {
        if (r10 != null) goto L5;
        Object r1 = null;
    L6:
        setEntity(r1);
        if (r10 != null) goto L15;
        this.entityWrittenToFallbackOnly = false;
        ConcurrentHashMap<String, String> r13 = this.ext;
        if (r13 == null) goto L11;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.remove(KEY_ENTITY_FALLBACK_JSON), String.class, "com.obric.aiagent.plugin");
    L11:
        ConcurrentHashMap<String, String> r9 = this.ext;
        if (r9 == null) goto L62;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r9.remove(KEY_ENTITY_FALLBACK_TYPE), String.class, "com.obric.aiagent.plugin");
        return;
    L62:
        return;
    L15:
        if (r12 == null) goto L17;
        boolean r16 = r12.booleanValue();
    L19:
        if (r11 != null) goto L47;
        if (r16 == true) goto L22;
    L45:
        Class<?> r17 = r10.getClass();
    L46:
        r11 = r17.getName();
        goto L47
    L22:
        if ((r10 instanceof Object[]) == false) goto L24;
        Object[] r18 = (Object[]) ZeusTransformUtils.preCheckCast(r10, Object[].class, "com.obric.aiagent.plugin");
    L25:
        if (r18 == null) goto L40;
        int r3 = r18.length;
        int r6 = 0;
    L27:
        if (r6 >= r3) goto L35;
        Object r7 = r18[r6];
        if (r7 == null) goto L31;
        boolean r8 = true;
    L32:
        if (r8 == true) goto L36;
        r6 = r6 + 1;
    L36:
        if (r7 == null) goto L40;
        r17 = r7.getClass();
        if (r17 == null) goto L40;
    L31:
        r8 = false;
        goto L32
    L35:
        r7 = null;
    L40:
        Class<?> r19 = r10.getClass().getComponentType();
        if (r19 == null) goto L43;
        r11 = r19.getName();
    L44:
        if (r11 != null) goto L47;
    L43:
        r11 = null;
        goto L44
    L24:
        r18 = null;
    L47:
        if (r16 == false) goto L58;
        r11 = r11 + "[]";
    L58:
        String r110 = b.a(CREATOR).toJson(r10);     // Catch: Throwable -> L55
        ConcurrentHashMap<String, String> r111 = this.ext;
        if (r111 != null) goto L53;
        r111 = new ConcurrentHashMap();
        this.ext = r111;
    L53:
        d.h.b.o.c(r110, "json");
        r111.put(KEY_ENTITY_FALLBACK_JSON, r110);
        d.h.b.o.c(r11, "typeTag");
        r111.put(KEY_ENTITY_FALLBACK_TYPE, r11);
        this.entityWrittenToFallbackOnly = true;
        return;
    L55:
        th = move-exception;
        INVOKESTATIC_com_obric_capabilitykit_common_intent_IntentResult_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "putEntityFallback toJson failed: " + th.getMessage());
        return;
    L17:
        r16 = r10 instanceof Object[];
        goto L19
    L5:
        r1 = r10;
        goto L6
    }

    public final void setDetails(String r1) {
        this.details = r1;
    }

    public final void setEntity(E r2) {
        if (r2 != null) goto L4;
    L10:
        this.entity = r2;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r2, Parcelable.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, Serializable.class) == true) goto L10;
        throw new RuntimeException("entity must be Parcelable or Serializable");
    }

    public final void setExt(ConcurrentHashMap<String, String> r1) {
        this.ext = r1;
    }

    public final void setFinal(boolean r1) {
        this.isFinal = r1;
    }

    public final void setFloatingIntentParams(FloatingIntentParams r1) {
        this.floatingIntentParams = r1;
    }

    public final void setInquireFurther(boolean r1) {
        this.inquireFurther = r1;
    }

    public final void setIntent(Intent r1) {
        this.intent = r1;
    }

    public final void setNeedToSummarize(boolean r1) {
        this.needToSummarize = r1;
    }

    public final void setRemoteCard(RemoteCard r1) {
        this.remoteCard = r1;
    }

    public final void setRet(int r1) {
        this.ret = r1;
    }

    public final void setUiType(int r1) {
        this.uiType = r1;
    }

    public final void setView(CardView r1) {
        this.view = r1;
    }

    public String toString() {
        return "IntentResult(ret=" + this.ret + ", view=" + this.view + ", details=" + this.details + ", uiType=" + this.uiType + ", ext=" + this.ext + ", inquireFurther=" + this.inquireFurther + ", needToSummarize=" + this.needToSummarize + ", entity=" + this.entity + ", intent=" + this.intent + ", floatingIntentParams=" + this.floatingIntentParams + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(2);
        d.h.b.o.e(r6, "parcel");
        r6.writeInt(this.ret);
        Parcelable r1 = null;
        Parcelable[] r2 = null;
        if (this.entityWrittenToFallbackOnly == false) goto L5;
        E r0 = null;
    L6:
        int r4 = 0;
        if ((r0 instanceof Object[]) == true) goto L9;
        r6.writeInt(0);
        if (ZeusTransformUtils.instanceOf(r0, Parcelable.class) == false) goto L23;
        r1 = (Parcelable) ZeusTransformUtils.preCheckCast(r0, Parcelable.class, "com.obric.aiagent.plugin");
    L23:
        r6.writeParcelable(r1, r7);
    L24:
        r6.writeParcelable(this.view, r7);
        r6.writeString(this.details);
        r6.writeParcelable(this.intent, r7);
        r6.writeParcelable(this.floatingIntentParams, r7);
        boolean r8 = this.inquireFurther;
        int r9 = r8;
        if (this.needToSummarize == false) goto L27;
        r9 = (r8 ? 1 : 0) | 2;
    L27:
        r6.writeInt(r9);
        r6.writeInt(this.uiType);
        r6.writeSerializable(this.ext);
        r6.writeValue(Boolean.valueOf(this.isFinal));
        r6.writeValue(this.remoteCard);
        return;
    L9:
        if ((r0 instanceof Parcelable[]) == false) goto L11;
        r2 = (Parcelable[]) ZeusTransformUtils.preCheckCast(r0, Parcelable[].class, "com.obric.aiagent.plugin");
    L11:
        r6.writeInt(1);
        if (r2 == null) goto L14;
        int r3 = r2.length;
    L15:
        r6.writeInt(r3);
        if (r2 == null) goto L24;
        int r5 = r2.length;
    L18:
        if (r4 >= r5) goto L24;
        r6.writeParcelable(r2[r4], r7);
        r4 = r4 + 1;
        goto L18
    L14:
        r3 = 0;
        goto L15
    L5:
        r0 = this.entity;
        goto L6
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_capabilitykit_common_intent_IntentResult_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
