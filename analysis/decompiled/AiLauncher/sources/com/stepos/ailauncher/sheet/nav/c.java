package com.stepos.ailauncher.sheet.nav;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.R$anim;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/sheet/nav/c;", "", "<init>", "()V", "Lcom/stepos/ailauncher/sheet/nav/b;", "SlideHorizontal", "Lcom/stepos/ailauncher/sheet/nav/b;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/sheet/nav/b;", "SlideVertical", "getSlideVertical", "Fade", "getFade", "None", "getNone", "Default", Const.INTENT_KEY_APIKEY, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private static final SheetFragmentAnim Default;
    private static final SheetFragmentAnim Fade;
    public static final c INSTANCE = new c();
    private static final SheetFragmentAnim None;
    private static final SheetFragmentAnim SlideHorizontal;
    private static final SheetFragmentAnim SlideVertical;

    static {
        SheetFragmentAnim sheetFragmentAnim = new SheetFragmentAnim(R$anim.ail_sheet_fragment_enter, R$anim.ail_sheet_fragment_exit, R$anim.ail_sheet_fragment_pop_enter, R$anim.ail_sheet_fragment_pop_exit);
        SlideHorizontal = sheetFragmentAnim;
        SlideVertical = new SheetFragmentAnim(R$anim.ail_sheet_fragment_vertical_enter, R$anim.ail_sheet_fragment_vertical_exit, R$anim.ail_sheet_fragment_vertical_pop_enter, R$anim.ail_sheet_fragment_vertical_pop_exit);
        int i10 = R$anim.ail_sheet_fragment_fade_in;
        int i11 = R$anim.ail_sheet_fragment_fade_out;
        Fade = new SheetFragmentAnim(i10, i11, i10, i11);
        None = SheetFragmentAnim.INSTANCE.a();
        Default = sheetFragmentAnim;
    }

    public final SheetFragmentAnim a() {
        return Default;
    }

    public final SheetFragmentAnim b() {
        return SlideHorizontal;
    }
}
