package com.obric.oui.avatar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OAvatarQueueViewV2WithClip.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f34000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f34001b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ b[] f34002c = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f34000a, f34001b};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f34002c.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f34000a = new b("Queue", 0);
        f34001b = new b("Group", 1);
        f34002c = a();
    }
}
