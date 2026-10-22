package com.bytedance.android.livesdk.chatroom.publicscreen;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class VideoShareAppLogger$sendEvent$1 extends Lambda implements Function1<HashMap<String, String>, Unit> {
    public static final VideoShareAppLogger$sendEvent$1 INSTANCE = null;

    static {
        INSTANCE = new VideoShareAppLogger$sendEvent$1();
    }

    public VideoShareAppLogger$sendEvent$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
