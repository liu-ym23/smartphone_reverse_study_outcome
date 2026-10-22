package com.bytedance.android.livesdk.chatroom.ui.framework;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes8.dex */
public interface a extends IAbility {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.a$a, reason: collision with other inner class name */
    public static final class C1672a {
        public static /* synthetic */ void b(a r100, Widget r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            boolean r103 = true;
        L6:
            r100.Zj(r101, r103, false);
            return;
        L5:
            r103 = false;
            goto L6
        }

        public static /* synthetic */ void a(a r100, int r101, Widget r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            r103 = true;
        L5:
            r100.Ro(r101, r102, r103, false);
        }
    }

    @Deprecated(message = "仅Saas同构使用")
    RecyclableWidgetManager Ao();

    <T extends LiveRecyclableWidget> void Cd(Class<T> r100, boolean r101, boolean r102);

    ViewLayerDelegate<? extends h70.b> E8();

    ah1.c E9();

    PropertyOwner Na();

    ViewLayerDelegate<? extends h70.b> Ni();

    void Og(j70.f r100);

    void Ro(int r100, Widget r101, boolean r102, boolean r103);

    void Uj(Widget r100);

    void Zj(Widget r100, boolean r101, boolean r102);

    PropertyOwner getLoadState();

    ViewLayerDelegate<? extends h70.b> hk();

    PropertyOwner i8();

    void vi(j70.f r100);

    Element<?> w8(j70.f r100);

    ah1.b xb();
}
