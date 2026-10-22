package c8c;

import android.content.Context;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDAvatarList;
import com.larksuite.component.universe_design.image.UDTextAvatar;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends UDAvatarList.AvatarAdapter<com.ss.android.lark.todo.impl.features.detail.sections.c> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f22763h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f22769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22770g;

    public static final class a {
    }

    static {
    }

    public f(List<com.ss.android.lark.todo.impl.features.detail.sections.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super(0, r100, 1, null);
        this.f22764a = 2;
        this.f22765b = R.color.bg_body;
        this.f22767d = 30;
        this.f22768e = "";
        this.f22769f = 14;
        this.f22770g = R.color.bg_filler;
    }

    @Override // com.larksuite.component.universe_design.image.UDAvatarList.AvatarAdapter
    public final UDAvatar getMoreAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDAvatar r101 = super.getMoreAvatar(r100);
        if ((r101 instanceof UDTextAvatar) == false) goto L5;
        UDTextAvatar r102 = (UDTextAvatar) r101;
    L6:
        if (r102 == null) goto L10;
        r102.setAvatarBgColor(y9c.d.c(r100, this.f22770g));
        r102.setBorderColor(y9c.d.c(r100, this.f22765b));
        r102.setBorderWidth(Float.valueOf(UIHelper.sp2px(this.f22764a)));
        r102.setAvatarSize((int) UIHelper.sp2px(this.f22767d));
        r102.setAvatarTextSize((int) UIHelper.sp2px(this.f22769f));
        if (this.f22766c == false) goto L10;
        r102.setAvatarText(this.f22768e);
    L10:
        return r101;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larksuite.component.universe_design.image.UDAvatarList.AvatarAdapter
    public final void onItemCreated(UDAvatar r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        r100.setAvatarSize((int) UIHelper.sp2px(this.f22767d));
        r100.setBorderWidth(Float.valueOf(UIHelper.sp2px(this.f22764a)));
        r100.setBorderColor(y9c.d.c(r100.getContext(), this.f22765b));
        com.ss.android.lark.todo.impl.features.detail.sections.c r102 = getItem(r101);
        if (r102 == null) goto L9;
        int r103 = r102.f443345d;
        if (r103 == 0) goto L7;
        r100.setImageResource(r103);
        return;
    L7:
        ImageLoader.with(r100.getContext()).load(AvatarImage.Builder.obtain(r102.f443343b, r102.f443342a, getAvatarSize(), getAvatarSize()).build()).into(r100);
        return;
    }
}
