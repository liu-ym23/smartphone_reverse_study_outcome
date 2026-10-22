package ao5;

import com.bytedance.ee.bear.templates.TemplateShowCardType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f15794a;

    @Override // ao5.e
    public final int getTemplateShowType() {
        return TemplateShowCardType.SHOW_CARD_TYPE_HEAD.ordinal();
    }

    public d(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f15794a = r100;
    }
}
