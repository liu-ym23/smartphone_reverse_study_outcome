package com.bytedance.android.shopping.commentv3.base;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0010\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0002\u0010\u0004*\u00020\u0000\"\u000e\b\u0003\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/base/b;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/android/shopping/commentv3/base/a;", "L", "State", "Logic", "Landroidx/lifecycle/MutableLiveData;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Landroidx/lifecycle/MutableLiveData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class BaseUI$bindLogic$1 extends Lambda implements Function1<MutableLiveData<b>, Unit> {
    final /* synthetic */ BaseCommentUI $child;

    public BaseUI$bindLogic$1(BaseCommentUI r100) {
        this.$child = r100;
        super(1);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MutableLiveData<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$child.f172669b.addSource(r100, (Observer<? super S>) new AnonymousClass1(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MutableLiveData<b> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
