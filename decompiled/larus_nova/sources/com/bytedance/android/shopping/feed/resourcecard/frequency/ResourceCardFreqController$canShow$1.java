package com.bytedance.android.shopping.feed.resourcecard.frequency;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import sk.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ResourceCardFreqController$canShow$1 extends FunctionReferenceImpl implements Function1<Integer, List<String>> {
    public ResourceCardFreqController$canShow$1(a r100) {
        super(1, r100, a.class, "getECInflowResourceCardShowRecord", "getECInflowResourceCardShowRecord(I)Ljava/util/List;", 0);
    }

    public final List<String> invoke(int r100) {
        ((a) this.receiver).getClass();
        return a.b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<String> invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
