package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui;

import com.bytedance.android.livesdk.chatroom.OverScrollRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public interface ITabView {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/ITabView$Scene;", "", "", "enableCameraSelectBg", "enablePaidCameraBuyButton", "enableLinkedGoWatchBtn", "SCENE_PORTRAIT_HORIZONTAL", "SCENE_PORTRAIT_VERTICAL", "SCENE_LANDSCAPE", "SCENE_PAD_LANDSCAPE", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Scene extends Enum<Scene> {
        public static final Scene SCENE_LANDSCAPE = null;
        public static final Scene SCENE_PAD_LANDSCAPE = null;
        public static final Scene SCENE_PORTRAIT_HORIZONTAL = null;
        public static final Scene SCENE_PORTRAIT_VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scene[] f159647a = null;

        static {
            Scene r100 = new Scene("SCENE_PORTRAIT_HORIZONTAL", 0);
            SCENE_PORTRAIT_HORIZONTAL = r100;
            Scene r101 = new Scene("SCENE_PORTRAIT_VERTICAL", 1);
            SCENE_PORTRAIT_VERTICAL = r101;
            Scene r102 = new Scene("SCENE_LANDSCAPE", 2);
            SCENE_LANDSCAPE = r102;
            Scene r103 = new Scene("SCENE_PAD_LANDSCAPE", 3);
            SCENE_PAD_LANDSCAPE = r103;
            f159647a = new Scene[]{r100, r101, r102, r103};
        }

        public static Scene valueOf(String r100) {
            return (Scene) r27.a.a(Scene.class, r100);
        }

        public static Scene[] values() {
            return (Scene[]) f159647a.clone();
        }

        public final boolean enableCameraSelectBg() {
            if (this != SCENE_PORTRAIT_VERTICAL) goto L5;
        L10:
            return true;
        L5:
            if (this == SCENE_PAD_LANDSCAPE) goto L10;
            if (this == SCENE_LANDSCAPE) goto L10;
            return false;
        }

        public final boolean enableLinkedGoWatchBtn() {
            if (this != SCENE_PORTRAIT_VERTICAL) goto L5;
        L10:
            return true;
        L5:
            if (this == SCENE_PAD_LANDSCAPE) goto L10;
            if (this == SCENE_LANDSCAPE) goto L10;
            return false;
        }

        public final boolean enablePaidCameraBuyButton() {
            if (this != SCENE_PORTRAIT_VERTICAL) goto L5;
        L10:
            return true;
        L5:
            if (this == SCENE_LANDSCAPE) goto L10;
            if (this == SCENE_PAD_LANDSCAPE) goto L10;
            return false;
        }

        public Scene(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/ITabView$TabType;", "", "", "tabName", "Ljava/lang/String;", "getTabName", "()Ljava/lang/String;", "TYPE_MULTI_CAMERA", "TYPE_LINKED_ROOM", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TabType extends Enum<TabType> {
        public static final TabType TYPE_LINKED_ROOM = null;
        public static final TabType TYPE_MULTI_CAMERA = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TabType[] f159648a = null;
        private final String tabName;

        static {
            TabType r100 = new TabType("TYPE_MULTI_CAMERA", 0, "more_machine");
            TYPE_MULTI_CAMERA = r100;
            TabType r101 = new TabType("TYPE_LINKED_ROOM", 1, "relevant_live");
            TYPE_LINKED_ROOM = r101;
            f159648a = new TabType[]{r100, r101};
        }

        public static TabType valueOf(String r100) {
            return (TabType) r27.a.a(TabType.class, r100);
        }

        public static TabType[] values() {
            return (TabType[]) f159648a.clone();
        }

        public final String getTabName() {
            return this.tabName;
        }

        public TabType(String r100, int r101, String r102) {
            super(r100, r101);
            this.tabName = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TabType f159649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f159650b;

        public final int hashCode() {
            return (this.f159649a.hashCode() * 31) + this.f159650b.hashCode();
        }

        public final TabType getType() {
            return this.f159649a;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
            return false;
        L12:
            if (r100 == null) goto L21;
            a r102 = (a) r100;
            if (this.f159649a == r102.f159649a) goto L17;
            return false;
        L17:
            if ((!Intrinsics.areEqual(this.f159650b, r102.f159650b)) == false) goto L19;
            return false;
        L19:
            return true;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.ITabView.TabItem");
        L8:
            r101 = null;
            goto L10
        }

        public a(TabType r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f159649a = r100;
            this.f159650b = r101;
        }
    }

    void attach();

    OverScrollRecyclerView i();

    void onDestroy();

    void onVisible();
}
