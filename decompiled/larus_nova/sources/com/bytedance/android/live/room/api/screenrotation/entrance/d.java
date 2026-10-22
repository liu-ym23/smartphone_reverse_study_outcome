package com.bytedance.android.live.room.api.screenrotation.entrance;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements IRotateEntrance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IRotateEntrance.Type f99125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f99126b = null;

    public d() {
    }

    public final String toString() {
        return "SensorEntrance";
    }

    static {
        f99126b = new d();
        f99125a = IRotateEntrance.Type.Sensor;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance
    public IRotateEntrance.Type getType() {
        return f99125a;
    }
}
