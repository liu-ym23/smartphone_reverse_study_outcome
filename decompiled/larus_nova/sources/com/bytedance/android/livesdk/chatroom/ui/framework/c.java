package com.bytedance.android.livesdk.chatroom.ui.framework;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import hh1.v0;
import hh1.w0;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface c extends IAbility {
    PropertyOwner Ce();

    Object Ep();

    d Gg();

    w0 J1();

    com.bytedance.android.live.core.arch.mvvm.d<Boolean> Qi();

    boolean R7();

    List<DialogInterface.OnKeyListener> S5();

    boolean V9();

    Bundle Wl();

    boolean dg();

    FragmentManager ea();

    com.bytedance.android.live.room.l ef();

    FragmentManager getChildFragmentManager();

    Fragment getFragment();

    LiveMode getLiveMode();

    com.bytedance.android.live.pushstream.d getLiveStream();

    v0 getLiveVideoClientFactory();

    Room getRoom();

    boolean hq();

    boolean isNestedOutside();

    boolean isPortrait();

    EnterRoomExtra k3();

    Object ng();

    boolean o5();

    FragmentActivity p0();

    List<View.OnTouchListener> u6();

    com.bytedance.android.live.room.h.b uq();

    com.bytedance.android.livesdk.chatroom.ui.framework.utils.e wl();
}
