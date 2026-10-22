package com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class SlcECTagElementViewManager$reportErrorEvent$1 extends Lambda implements Function0<HashMap<String, Object>> {
    final /* synthetic */ String $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ String $tempDataType;
    final /* synthetic */ String $tempTagShowPagePosition;
    final /* synthetic */ String $tempTagShowScene;

    public SlcECTagElementViewManager$reportErrorEvent$1(String r100, String r101, String r102, String r103, String r104) {
        this.$errorCode = r100;
        this.$errorMsg = r101;
        this.$tempTagShowScene = r102;
        this.$tempTagShowPagePosition = r103;
        this.$tempDataType = r104;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HashMap<String, Object> invoke2() {
        HashMap<String, Object> r100 = new HashMap();
        r100.put("error_code", this.$errorCode);
        r100.put("error_msg", this.$errorMsg);
        r100.put("tag_show_scene", this.$tempTagShowScene);
        r100.put("tag_show_page_position", this.$tempTagShowPagePosition);
        r100.put("data_type", this.$tempDataType);
        r100.put("component_type", URLDispatch.KEY_ETAG);
        SlcECTagElementViewManager.f50570c4.getClass();
        SlcECTagElementViewManager.Companion.a(r100);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HashMap<String, Object> invoke() {
        return invoke2();
    }
}
