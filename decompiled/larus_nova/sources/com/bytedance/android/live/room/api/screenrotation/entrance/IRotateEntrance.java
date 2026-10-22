package com.bytedance.android.live.room.api.screenrotation.entrance;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
public interface IRotateEntrance {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/entrance/IRotateEntrance$Type;", "", "UI", "Sensor", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type Sensor = null;
        public static final Type UI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f99122a = null;

        static {
            Type r100 = new Type("UI", 0);
            UI = r100;
            Type r101 = new Type("Sensor", 1);
            Sensor = r101;
            f99122a = new Type[]{r100, r101};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f99122a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    Type getType();
}
