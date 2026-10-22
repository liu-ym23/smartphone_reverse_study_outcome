package com.bytedance.android.live.room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hh1.v0;
import hh1.w0;

/* JADX INFO: loaded from: classes47.dex */
public interface h extends gs0.d {
    public static final String I0 = null;

    public interface a {
        void a();
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(kj r100);

        public abstract void b(int r100);
    }

    void C60();

    void Cp(v0 r100);

    void Cz(nz.r r100);

    void D2(boolean r100);

    void DS();

    void F30(Room r100, EnterRoomExtra r101, w r102);

    void I5();

    View IP();

    void Oz(PadOrientation r100);

    void P7(Room r100, w r101);

    void R40(w0 r100);

    void R5();

    void RJ(Runnable r100);

    void Sb(View.OnTouchListener r100);

    void T4(Room r100, w r101);

    boolean V9();

    void VX(DataCenter r100, b r101, EnterRoomExtra r102);

    void b0(String r100);

    void bW(Room r100, EnterRoomExtra r101, Runnable r102);

    void cU(a r100);

    void cx(DialogInterface.OnKeyListener r100);

    void eR(LiveMode r100);

    View ff();

    boolean g1();

    FragmentManager getChildFragmentManager();

    boolean interceptCloseRoom(Runnable r100, boolean r101);

    boolean isAdded();

    boolean isScreenPortrait();

    void lO(com.bytedance.android.live.pushstream.d r100);

    void n9(Room r100, w r101);

    void ns();

    boolean o5();

    void onActivityResult(int r100, int r101, Intent r102);

    void onOuterPageScrollStateChanged(int r100);

    void onPageScrollStateChanged(int r100);

    boolean pX();

    Fragment self();

    void setArguments(Bundle r100);

    void setDataContext(RoomContext r100);

    void setNestedOutside(boolean r100);

    void show(FragmentManager r100, String r101);

    void stopInteractionLoad();

    void yv();

    void zA(EnterRoomInfoResult r100);

    static {
        String r100 = LiveCommonConstants.IInteractionFragment_TAG;
        I0 = "AbsInteractionFragment";
    }
}
