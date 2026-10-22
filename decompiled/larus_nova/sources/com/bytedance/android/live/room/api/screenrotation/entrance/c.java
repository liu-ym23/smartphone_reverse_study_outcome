package com.bytedance.android.live.room.api.screenrotation.entrance;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements IRotateEntrance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IRotateEntrance.Type f99123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f99124b = null;

    public c() {
    }

    public final String toString() {
        return "LandscapeEntrance";
    }

    static {
        f99124b = new c();
        f99123a = IRotateEntrance.Type.UI;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance
    public IRotateEntrance.Type getType() {
        return f99123a;
    }
}
