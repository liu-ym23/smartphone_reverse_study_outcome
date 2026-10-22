package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;
import com.ss.android.ugc.effectmanager.effect.listener.IUpdateTagListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface k {

    public interface a {
        void a(List<Effect> r100, EffectDataFetchCacheType r101);

        void onFetchFailed();
    }

    public interface b {
        void a(List<Effect> r100, EffectDataFetchCacheType r101);

        void onFetchFailed();
    }

    public interface c {
        void a(CategoryInfoModelList r100, EffectDataFetchCacheType r101);

        void onFetchFailed();
    }

    public interface d {
        void a(PanelInfoModel r100, EffectDataFetchCacheType r101);

        void onFetchFailed();
    }

    public interface e {
        void onFetchFailed();

        void onFetchSuccess(List<Effect> r100);
    }

    public interface f {
        void O1(String r100, Sticker r101);

        void Z(String r100, Sticker r101);

        void z0(String r100, Sticker r101, ExceptionResult r102);
    }

    public interface g extends f {
        void onProgress(int r100, long r101);
    }

    public interface h {
        void a(EffectCategoryResponse r100);
    }

    public interface i {
        void a(EffectChannelResponse r100);

        void b();
    }

    public interface j extends i {
        void c(EffectChannelResponse r100, EffectDataFetchCacheType r101);
    }

    void a(String r100, int r101);

    void b(String r100, String r101, IIsTagNeedUpdatedListener r102);

    void c(String r100);

    void d(String r100, IFetchEffectListener r101);

    boolean e(Effect r100);

    void f(String r100, Sticker r101, boolean r102);

    void g(String r100, Sticker r101, f r102);

    EffectCategoryResponse h(String r100);

    void i(String r100);

    void j(List<String> r100, IFetchEffectListListener r101);

    void k(String r100, int r101);

    void l(String r100, i r101);

    void m(String r100, StickerDataViewModel.C98861 r101);

    void n(String r100, String r101, IUpdateTagListener r102);

    boolean o(String r100, Sticker r101);

    void p(String r100, i r101, boolean r102);

    boolean q(Sticker r100);
}
