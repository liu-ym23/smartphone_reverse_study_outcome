package aob;

import com.ss.android.lark.biz.im.api.extension.chat_window.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements d<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f15819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f15820b;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "status_transform_inner_end_view";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final a getPlugin() {
        return new a(this.f15820b);
    }

    public b(v r100, com.ss.android.lark.biz.im.api.extension.chat_window.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f15819a = r100;
        this.f15820b = r101;
    }
}
