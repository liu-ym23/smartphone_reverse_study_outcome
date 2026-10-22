package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.b1;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public abstract class f implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f189552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f189553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f189554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Map<String, String>> f189555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CardPosition f189556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fo.b f189557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b1 f189558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.list.entity.j f189559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f189560i;

    public String b() {
        return null;
    }

    public WindowV2ProductItemVO c() {
        return null;
    }

    public void d() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return this.f189560i;
    }

    public f(int r100) {
        this.f189560i = r100;
        this.f189556e = CardPosition.NORMAL;
        this.f189557f = new fo.b();
    }
}
