package com.bytedance.android.livesdk.interactivity.api.publicscreen.listener;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import kotlin.Metadata;
import tlc.d;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/listener/ITextMessageView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITextMessageView extends IWidget {
    void Br(String r100);

    void DD(int r100, int r101, long r102);

    void Ev();

    void V50(int r100, boolean r101);

    void VA(int r100, long r101);

    void XD(int r100, long r101);

    void ZE();

    void a40();

    boolean d();

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    /* synthetic */ Context getContext();

    void lU(d r100);

    void pa(int r100);

    void sU(int r100);
}
