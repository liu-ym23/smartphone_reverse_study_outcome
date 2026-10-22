package com.bytedance.android.live.liveinteract.linkbase.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
public final class MediaOperation {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/MediaOperation$Action;", "", "", "value", "I", "getValue", "()I", "CLOSE", "OPEN", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Action extends Enum<Action> {
        public static final Action CLOSE = null;
        public static final Action OPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f74280a = null;
        private final int value;

        static {
            Action r100 = new Action("CLOSE", 0, 0);
            CLOSE = r100;
            Action r101 = new Action("OPEN", 1, 1);
            OPEN = r101;
            f74280a = new Action[]{r100, r101};
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) f74280a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/MediaOperation$Type;", "", "", "value", "I", "getValue", "()I", "CAMERA", "MIC", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Type extends Enum<Type> {
        public static final Type CAMERA = null;
        public static final Type MIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f74281a = null;
        private final int value;

        static {
            Type r100 = new Type("CAMERA", 0, 0);
            CAMERA = r100;
            Type r101 = new Type("MIC", 1, 1);
            MIC = r101;
            f74281a = new Type[]{r100, r101};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f74281a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface a {
        void onError(Throwable r100);

        void onSuccess();
    }

    public static final class b {
    }

    static {
    }

    public final Type getType() {
        return null;
    }
}
