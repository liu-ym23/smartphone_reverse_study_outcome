package ai8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.block.Block;
import ic8.w;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Block> f3841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f3844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f3845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MessageStatus f3846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ChatPageContext f3847g;

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
        return this.f3847g;
    }

    @Override // ic8.w
    public final Map<String, String> a() {
        return this.f3844d;
    }

    @Override // ic8.w
    public final String b() {
        return this.f3843c;
    }

    @Override // ic8.w
    public final MessageRequestType d() {
        return MessageRequestType.SEND_TEXT;
    }

    @Override // ic8.w
    public final Map<String, String> f() {
        return this.f3845e;
    }

    @Override // ic8.w
    public final MessageStatus i() {
        return this.f3846f;
    }

    @Override // ic8.w
    public final w c(Map<String, String> r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        Intrinsics.checkNotNullParameter(r111, "bizExt");
        return new g(this.f3841a, this.f3842b, this.f3843c, r110, r111, this.f3846f, this.f3847g);
    }

    public g(List<Block> r100, String r101, String r102, Map<String, String> r103, Map<String, String> r104, MessageStatus r105, ChatPageContext r106) {
        Intrinsics.checkNotNullParameter(r100, "blocks");
        this.f3841a = r100;
        this.f3842b = r101;
        this.f3843c = r102;
        this.f3844d = r103;
        this.f3845e = r104;
        this.f3846f = r105;
        this.f3847g = r106;
    }
}
