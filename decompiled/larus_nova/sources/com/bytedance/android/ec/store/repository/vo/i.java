package com.bytedance.android.ec.store.repository.vo;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/i;", "Lcom/ss/android/ugc/aweme/kiwi/model/QModel;", "", "name", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "data", "d", ce.f26395j, "moduleUrl", "e", ce.f26396k, "", "containerType", "I", "b", "()I", "h", "(I)V", "", "Lcom/bytedance/android/ec/store/repository/dto/f;", "rules", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "m", "(Ljava/util/List;)V", "", "coverBottomTab", "Z", "c", "()Z", RXScreenCaptureService.KEY_INDEX, "(Z)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48459a = 0;

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    private int containerType;

    @SerializedName("cover_bottom_tab")
    private boolean coverBottomTab;

    @SerializedName("data")
    private String data;

    @SerializedName("module_url")
    private String moduleUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("rules")
    private List<com.bytedance.android.ec.store.repository.dto.f> rules;

    public static final class a {
        public static i a(com.bytedance.android.ec.store.repository.dto.d r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            i r101 = new i();
            r101.l(r100.e());
            r101.j(r100.c());
            r101.k(r100.d());
            r101.h(r100.a());
            r101.m(r100.f());
            r101.i(r100.b());
            return r101;
        }
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 0;
    }

    public i() {
        this.name = "";
        this.data = "";
        this.moduleUrl = "";
    }

    public final int b() {
        return this.containerType;
    }

    public final boolean c() {
        return this.coverBottomTab;
    }

    public final String d() {
        return this.data;
    }

    public final String e() {
        return this.moduleUrl;
    }

    public final String f() {
        return this.name;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.f> g() {
        return this.rules;
    }

    public final void h(int r100) {
        this.containerType = r100;
    }

    public final void i(boolean r100) {
        this.coverBottomTab = r100;
    }

    public final void j(String r100) {
        this.data = r100;
    }

    public final void k(String r100) {
        this.moduleUrl = r100;
    }

    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void m(List<com.bytedance.android.ec.store.repository.dto.f> r100) {
        this.rules = r100;
    }
}
