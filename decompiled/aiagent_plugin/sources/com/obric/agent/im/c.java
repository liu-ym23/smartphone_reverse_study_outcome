package com.obric.agent.im;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: MessageStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14585a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("0")
    public static final c f14586c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("1")
    public static final c f14587d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("3")
    public static final c f14588e = null;

    @SerializedName("5")
    public static final c f = null;

    @SerializedName("7")
    public static final c g = null;

    @SerializedName("6")
    public static final c h = null;

    @SerializedName("8")
    public static final c i = null;

    @SerializedName("9")
    public static final c j = null;

    @SerializedName("10")
    public static final c k = null;

    @SerializedName("11")
    public static final c l = null;
    private static final /* synthetic */ c[] m = null;
    private static final /* synthetic */ d.d.a n = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14589b;

    /* JADX INFO: compiled from: MessageStatus.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ c[] a() {
        return new c[]{f14586c, f14587d, f14588e, f, g, h, i, j, k, l};
    }

    private c(String r1, int r2, int r3) {
        super(r1, r2);
        this.f14589b = r3;
    }

    static {
        f14586c = new c("MessageStatus_AVAILABLE", 0, 0);
        f14587d = new c("MessageStatus_INVISIBLE", 1, 1);
        f14588e = new c("MessageStatus_NOT_EXIST", 2, 3);
        f = new c("MessageStatus_DELETED", 3, 5);
        g = new c("MessageStatus_BEFOREEDIT", 4, 7);
        h = new c("MessageStatus_EDITED", 5, 6);
        i = new c("MessageStatus_REGEN_ROOT", 6, 8);
        j = new c("MessageStatus_UNSELECTED", 7, 9);
        k = new c("MessageStatus_REGENATED", 8, 10);
        l = new c("MessageStatus_NOTCOMPLIANT", 9, 11);
        c[] r0 = a();
        m = r0;
        n = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f14585a = new a(null);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(m.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
