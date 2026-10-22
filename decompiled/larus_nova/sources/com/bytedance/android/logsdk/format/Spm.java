package com.bytedance.android.logsdk.format;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001/B\u0011\b\u0002\u0012\u0006\u0010(\u001a\u00020\u0004¢\u0006\u0004\b-\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0000J\u001a\u0010\u0013\u001a\u00020\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0012J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0012J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0010\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J\u0006\u0010 \u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\"R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010!R\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010!R$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010#R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/logsdk/format/Spm;", "", "", "recycle", "", "log", "logAndRecycle", "", "type", "fromSpm", "result", "reason", "resultSuccess", "priority", RXScreenCaptureService.KEY_INDEX, "d", "w", "e", "", "args", "key", "value", "addArg", "addArgs", "businessId", "roomId", "anchorId", "userId", "roleType", "msg", "aliasAppend", "tagSuffix", e1.REPLY_ACTION_APPLY, "I", "Ljava/lang/String;", "Ljava/util/Map;", "alias", "", "timestamp", "J", "spm", "getSpm", "()Ljava/lang/String;", "setSpm", "(Ljava/lang/String;)V", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-logsdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Spm {
    private static final String ANCHOR_ID = "anchor_id";
    private static final String BUSINESS_ID = "business_id";
    public static final a Companion = null;
    private static final int LENGTH = 0;
    public static final int ROLE_RESULT_SUCCESS = 0;
    public static final int ROLE_RESULT_UNKNOWN_FAILED = -1;
    private static final String ROLE_TYPE = "role_type";
    private static final String ROLE_TYPE_ANCHOR = "1";
    private static final String ROLE_TYPE_AUDIENCE = "0";
    private static final String ROOM_ID = "room_id";
    private static final String USER_ID = "user_id";
    private static ConcurrentLinkedQueue<SoftReference<Spm>> mSpmPools;
    private String alias;
    private Map<String, Object> args;
    private String fromSpm;
    private int priority;
    private String reason;
    private int result;
    private String spm;
    private long timestamp;
    private int type;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static Spm a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spm");
            return b(r100, 19999);
        }

        @JvmStatic
        public static Spm b(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "spm");
            SoftReference r102 = (SoftReference) Spm.access$getMSpmPools$cp().poll();
            if (r102 == null) goto L6;
            Spm r103 = (Spm) r102.get();
            if (r103 == null) goto L6;
        L7:
            Spm.access$setTimestamp$p(r103, System.currentTimeMillis());
            r103.setSpm(r100);
            return r103.type(r101);
        L6:
            r103 = new Spm(r100, null);
            goto L7
        }
    }

    @JvmStatic
    public static final Spm obtain(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    @JvmStatic
    public static final Spm obtain(String r100, int r101) {
        Companion.getClass();
        return a.b(r100, r101);
    }

    public final Spm resultSuccess() {
        this.result = 0;
        return this;
    }

    static {
        Companion = new a();
        LENGTH = 256;
        mSpmPools = new ConcurrentLinkedQueue();
    }

    @JvmStatic
    public static final Spm obtain() {
        Companion.getClass();
        return a.a("a100.b7000");
    }

    private final void recycle() {
        if (mSpmPools.size() <= LENGTH) goto L5;
        return;
    L5:
        this.spm = "";
        this.type = 19999;
        this.fromSpm = "";
        this.result = 200;
        this.priority = 0;
        this.alias = "";
        this.reason = "";
        Map<String, Object> r100 = this.args;
        if (r100 == null) goto L8;
        r100.clear();
    L8:
        mSpmPools.offer(new SoftReference(this));
    }

    public final void apply() {
        sw2.a.b(this, "");
    }

    public final Spm d() {
        int r100 = xw2.a.f565221a;
        this.priority = 300;
        return this;
    }

    public final Spm e() {
        int r100 = xw2.a.f565221a;
        this.priority = 600;
        return this;
    }

    public final Spm i() {
        int r100 = xw2.a.f565221a;
        this.priority = 400;
        return this;
    }

    public final String log() {
        return GsonProtectorUtils.toJson(zw2.a.f573798a, this);
    }

    public final Spm w() {
        int r100 = xw2.a.f565221a;
        this.priority = 500;
        return this;
    }

    public final String logAndRecycle() {
        String r100 = log();
        recycle();
        return r100;
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getMSpmPools$cp() {
        return mSpmPools;
    }

    public final String getSpm() {
        return this.spm;
    }

    public final int priority() {
        return this.priority;
    }

    public final int result() {
        return this.result;
    }

    private Spm(String r100) {
        this.spm = r100;
        this.type = 19999;
        this.result = 200;
        this.alias = "";
        this.reason = "";
        this.timestamp = System.currentTimeMillis();
    }

    public static final /* synthetic */ long access$getTimestamp$p(Spm r100) {
        return r100.timestamp;
    }

    public static final /* synthetic */ void access$setMSpmPools$cp(ConcurrentLinkedQueue r100) {
        mSpmPools = r100;
    }

    public final Spm addArgs(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        if (this.args != null) goto L5;
        this.args = new HashMap();
    L5:
        Map<String, Object> r101 = this.args;
        if (r101 == null) goto L8;
        r101.putAll(r100);
    L8:
        return this;
    }

    public final Spm aliasAppend(String r100) {
        if (r100 != null) goto L4;
    L6:
        return this;
    L4:
        if (this.alias.length() >= 1024) goto L6;
        this.alias = this.alias + r100;
        goto L6
    }

    public final Spm anchorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        return addArg("anchor_id", r100);
    }

    public final void apply(String r100) {
        sw2.a.b(this, r100);
    }

    public final Spm args(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        this.args = r100;
        return this;
    }

    public final Spm businessId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "businessId");
        return addArg("business_id", r100);
    }

    public final Spm fromSpm(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fromSpm");
        this.fromSpm = r100;
        return this;
    }

    public final Spm priority(int r100) {
        this.priority = r100;
        return this;
    }

    public final Spm reason(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        boolean r101 = true;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L13:
        this.reason = r100;
        return this;
    L8:
        if (this.reason.length() == 0) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L13;
        return this;
    L5:
        r102 = false;
        goto L6
    }

    public final Spm result(int r100) {
        this.result = r100;
        return this;
    }

    public final Spm roleType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roleType");
        return addArg("role_type", r100);
    }

    public final Spm roomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        return addArg("room_id", r100);
    }

    public final void setSpm(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spm = r100;
    }

    public final Spm type(int r100) {
        this.type = r100;
        return this;
    }

    public final Spm userId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return addArg("user_id", r100);
    }

    public /* synthetic */ Spm(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public static final /* synthetic */ void access$setTimestamp$p(Spm r100, long r101) {
        r100.timestamp = r101;
    }

    public final Spm addArg(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.args != null) goto L5;
        this.args = new HashMap();
    L5:
        if (r101 == null) goto L7;
        Map<String, Object> r102 = this.args;
        Intrinsics.checkNotNull(r102);
        r102.put(r100, r101);
    L7:
        return this;
    }

    public final Spm result(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.result = r100;
        this.reason = r101;
        return this;
    }

    public static /* synthetic */ Spm result$default(Spm r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "";
    L6:
        return r100.result(r101, r102);
    }
}
