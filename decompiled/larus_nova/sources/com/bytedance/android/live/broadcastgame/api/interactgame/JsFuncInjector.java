package com.bytedance.android.live.broadcastgame.api.interactgame;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
public interface JsFuncInjector {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/interactgame/JsFuncInjector$Type;", "", "", "value", "I", "getValue", "()I", "WMINI", "EFFECT", "LYNX_PANEL", "EFFECT_PANEL", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type EFFECT = null;
        public static final Type EFFECT_PANEL = null;
        public static final Type LYNX_PANEL = null;
        public static final Type WMINI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f59298a = null;
        private final int value;

        static {
            Type r100 = new Type("WMINI", 0, -2);
            WMINI = r100;
            Type r101 = new Type("EFFECT", 1, -3);
            EFFECT = r101;
            Type r102 = new Type("LYNX_PANEL", 2, -1);
            LYNX_PANEL = r102;
            Type r103 = new Type("EFFECT_PANEL", 3, -4);
            EFFECT_PANEL = r103;
            f59298a = new Type[]{r100, r101, r102, r103};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f59298a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }
}
