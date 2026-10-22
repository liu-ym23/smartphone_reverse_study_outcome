package ai8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import ic8.w;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f3797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f3802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f3803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MessageStatus f3804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ChatPageContext f3805i;

    @Override // ic8.w
    public final ReferenceInfo T6() {
        return null;
    }

    @Override // ic8.w
    public final String content() {
        return "";
    }

    @Override // ic8.w
    public final int contentType() {
        return 9999;
    }

    @Override // ic8.w
    public final Map<String, String> e() {
        return null;
    }

    @Override // ic8.w
    public final String g() {
        return null;
    }

    @Override // ic8.w
    public final Pair<String, String> h() {
        return null;
    }

    @Override // ic8.w
    public final ChatPageContext N() {
        return this.f3805i;
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        return this.f3802f;
    }

    @Override // ic8.w
    public final String b() {
        return this.f3801e;
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        return MessageRequestType.SEND_TEXT;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
        return this.f3803g;
    }

    @Override // ic8.w
    public final MessageStatus i() {
        return this.f3804h;
    }

    @Override // ic8.w
    public final w c(Map<String, String> r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        Intrinsics.checkNotNullParameter(r111, "bizExt");
        return new c(this.f3797a, this.f3798b, this.f3799c, this.f3800d, this.f3801e, r110, r111, this.f3804h, this.f3805i);
    }

    public c(List<Long> r100, int r101, String r102, long r103, String r104, Map<String, String> r105, Map<String, String> r106, MessageStatus r110, ChatPageContext r111) {
        Intrinsics.checkNotNullParameter(r100, "bizMessageIds");
        Intrinsics.checkNotNullParameter(r102, SelectInfo.BRIEF);
        this.f3797a = r100;
        this.f3798b = r101;
        this.f3799c = r102;
        this.f3800d = r103;
        this.f3801e = r104;
        this.f3802f = r105;
        this.f3803g = r106;
        this.f3804h = r110;
        this.f3805i = r111;
    }
}
