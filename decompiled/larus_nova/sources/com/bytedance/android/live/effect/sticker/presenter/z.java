package com.bytedance.android.live.effect.sticker.presenter;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchFavoriteList;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.model.net.FetchFavoriteListResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class z extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.live.effect.api.k.i> f68420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, EffectChannelResponse> f68421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, EffectCategoryResponse> f68422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, com.bytedance.android.live.effect.api.k.h> f68423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f68424i;

    public class a implements IFetchFavoriteList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f68425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z f68426b;

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchFavoriteList
        public final void onFailed(ExceptionResult r100) {
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(FetchFavoriteListResponse r100) {
            FetchFavoriteListResponse r101 = r100;
            if (r101 == null) goto L13;
            this.f68426b.r(this.f68425a);
            Map<String, EffectCategoryResponse> r102 = this.f68426b.f68422g;
            HashMap r103 = (HashMap) r102;
            EffectCategoryResponse r104 = (EffectCategoryResponse) r103.get(this.f68425a);
            if (r104 == null) goto L11;
            r104.setTotalEffects(r101.getEffects());
            r104.setTagsUpdateTime("0");
            Map<String, com.bytedance.android.live.effect.api.k.h> r105 = this.f68426b.f68423h;
            HashMap r106 = (HashMap) r105;
            com.bytedance.android.live.effect.api.k.h r107 = (com.bytedance.android.live.effect.api.k.h) r106.get(this.f68425a);
            if (r107 == null) goto L12;
            r107.a(r104);
            return;
        L12:
            return;
        L11:
            return;
        }

        public a(z r100, String r101) {
            this.f68426b = r100;
            this.f68425a = r101;
        }
    }

    public class b implements IFetchEffectListListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFetchEffectListener f68427a;

        public b(IFetchEffectListener r100) {
            this.f68427a = r100;
        }

        @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListListener
        public final void onFail(ExceptionResult r100) {
            this.f68427a.onFail(null, r100);
        }

        @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
        public final void onSuccess(List<Effect> r100) {
            List<Effect> r101 = r100;
            if (r101 != null) goto L5;
        L7:
            this.f68427a.onFail(null, new ExceptionResult(1));
            return;
        L5:
            if (r101.isEmpty() == true) goto L7;
            this.f68427a.onSuccess((Effect) ListProtector.get(r101, 0));
        }
    }

    public z(LiveEffectContextFactoryDelegate$Type r100) {
        super(r100);
        this.f68424i = Boolean.FALSE;
        this.f68419d = r100;
        this.f68420e = new ArrayList();
        this.f68421f = new HashMap();
        this.f68422g = new HashMap();
        this.f68423h = new HashMap();
        new HashMap();
        new HashMap();
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void c(String r100) {
        EffectManager r101 = this.f68308a;
        if (r101 != null) goto L5;
        return;
    L5:
        r(r100);
        r101.fetchFavoriteList(r100, new a(this, r100));
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final EffectCategoryResponse h(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return (EffectCategoryResponse) ((HashMap) this.f68422g).get(r100);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void i(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        ((HashMap) this.f68423h).remove(r100);
    }

    public final void r(String r100) {
        if (((HashMap) this.f68422g).containsKey(r100) == false) goto L5;
        return;
    L5:
        Map<String, EffectCategoryResponse> r101 = this.f68422g;
        EffectCategoryResponse r102 = new EffectCategoryResponse();
        r102.setId("1");
        r102.setName(s1.B(R.string.ttlive_effect_favorite_text_normal));
        r102.setKey("");
        ((HashMap) r101).put(r100, r102);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void a(String r110, int r111) {
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r100 = com.bytedance.android.live.effect.api.u.f66774a;
        com.bytedance.android.live.effect.api.u.b(this.f68419d).a().n(r110, false, "", r111, 0, false, null, false);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void d(String r100, IFetchEffectListener r101) {
        IFetchEffectListListener r102 = new b(r101);
        ArrayList r103 = new ArrayList();
        r103.add(r100);
        j(r103, r102);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void j(List<String> r100, IFetchEffectListListener r101) {
        this.f68308a.fetchEffectList(r100, false, null, r101);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void k(String r100, int r101) {
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r102 = com.bytedance.android.live.effect.api.u.f66774a;
        com.bytedance.android.live.effect.api.u.b(this.f68419d).a().r(r100, "hot", r101, null);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void l(String r100, com.bytedance.android.live.effect.api.k.i r101) {
        p(r100, r101, false);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void m(String r100, StickerDataViewModel.C98861 r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        ((HashMap) this.f68423h).put(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final boolean o(String r100, Sticker r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
        return false;
    L7:
        Effect r102 = r101.getEffect();
        if (r102 != null) goto L10;
        return false;
    L10:
        EffectCategoryResponse r103 = (EffectCategoryResponse) ((HashMap) this.f68422g).get(r100);
        if (r103 != null) goto L13;
        return false;
    L13:
        List<Effect> r104 = r103.getTotalEffects();
        if (r104 != null) goto L17;
        return false;
    L17:
        return r104.contains(r102);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void f(String r100, Sticker r101, boolean r102) {
        if (this.f68424i.booleanValue() == false) goto L5;
        return;
    L5:
        if (s(r100, r101, r102) == false) goto L10;
        String r103 = r101.getEffect().getEffectId();
        this.f68424i = Boolean.TRUE;
        this.f68308a.modifyFavoriteList(r100, r103, Boolean.valueOf(r102), new y(this, r100, r102, r101));
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void p(String r100, com.bytedance.android.live.effect.api.k.i r101, boolean r110) {
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r102 = com.bytedance.android.live.effect.api.u.f66774a;
        com.bytedance.android.live.effect.api.u.a(this.f68419d).d().a().a(r100, r101, true, r110, false, false);
    }

    public final boolean s(String r100, Sticker r101, boolean r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r101 == null) goto L18;
        Effect r103 = r101.getEffect();
        if (r103 == null) goto L18;
        EffectCategoryResponse r104 = (EffectCategoryResponse) ((HashMap) this.f68422g).get(r100);
        if (r104 != null) goto L12;
        return false;
    L12:
        ArrayList r105 = new ArrayList(r104.getTotalEffects());
        if (r102 == false) goto L15;
        ListProtector.add(r105, 0, r103);
    L16:
        r104.setTotalEffects(r105);
        ((HashMap) this.f68422g).put(r100, r104);
        return true;
    L15:
        r105.remove(r103);
    L18:
        return false;
    }
}
