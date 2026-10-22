package com.stepos.widget.tabbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import com.stepos.widget.R;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import n9.C4946a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\tH\u0002J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00132\b\b\u0001\u0010\u0010\u001a\u00020\tH\u0002J(\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabMenuParser;", "", "<init>", "()V", "TAG_MENU", "", "TAG_ITEM", "TAG_GROUP", "NO_RES", "", "DEPTH_TAB_ITEM", M5.e.FAIL_PARSE, "", "Lcom/stepos/widget/tabbar/ParsedTabMenuItem;", "context", "Landroid/content/Context;", "menuRes", "parse$StepOSWidget_release", "openMenuResource", "Landroid/content/res/XmlResourceParser;", "parseMenu", "parser", "readItem", "attrs", "Landroid/util/AttributeSet;", "line", "menuName", "nameOf", "resId", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSTabMenuParser {
    private static final int DEPTH_TAB_ITEM = 2;
    public static final StepOSTabMenuParser INSTANCE = new StepOSTabMenuParser();
    private static final int NO_RES = 0;
    private static final String TAG_GROUP = "group";
    private static final String TAG_ITEM = "item";
    private static final String TAG_MENU = "menu";

    private StepOSTabMenuParser() {
    }

    private final String nameOf(Context context, int resId) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(context.getResources().getResourceName(resId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            objB = "0x" + Integer.toHexString(resId);
        }
        return (String) objB;
    }

    private final XmlResourceParser openMenuResource(Context context, int menuRes) throws Resources.NotFoundException {
        XmlResourceParser layout = context.getResources().getLayout(menuRes);
        kotlin.jvm.internal.p.h(layout, "getLayout(...)");
        return layout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0168, code lost:
    
        throw new java.lang.IllegalArgumentException(r13 + " 第 " + r12.getLineNumber() + " 行出现无法识别的标签 <" + r6 + ">：StepOSTabBar 的 menu 只支持 <menu> 根标签与平铺的 <item> 子标签");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0169, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.stepos.widget.tabbar.ParsedTabMenuItem> parseMenu(android.content.Context r11, android.content.res.XmlResourceParser r12, int r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.tabbar.StepOSTabMenuParser.parseMenu(android.content.Context, android.content.res.XmlResourceParser, int):java.util.List");
    }

    private final ParsedTabMenuItem readItem(Context context, AttributeSet attrs, int line, String menuName) throws Exception {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.StepOSTabMenuItem);
        try {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSTabMenuItem_android_id, 0);
            if (resourceId != 0) {
                ParsedTabMenuItem parsedTabMenuItem = new ParsedTabMenuItem(resourceId, typedArrayObtainStyledAttributes.getText(R.styleable.StepOSTabMenuItem_android_title), typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSTabMenuItem_android_icon, 0), typedArrayObtainStyledAttributes.getText(R.styleable.StepOSTabMenuItem_android_contentDescription), typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTabMenuItem_android_visible, true), typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTabMenuItem_android_enabled, true));
                C4946a.a(typedArrayObtainStyledAttributes, null);
                return parsedTabMenuItem;
            }
            throw new IllegalArgumentException((menuName + " 第 " + line + " 行的 <item> 缺少 android:id。itemId 是页签选中态的唯一身份依据（选中、转屏状态恢复、与 ViewPager2 对齐都靠它），必须显式给出，例如 android:id=\"@+id/stepos_tab_dialer\"").toString());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C4946a.a(typedArrayObtainStyledAttributes, th);
                throw th2;
            }
        }
    }

    public final List<ParsedTabMenuItem> parse$StepOSWidget_release(Context context, int menuRes) throws Exception {
        kotlin.jvm.internal.p.i(context, "context");
        if (menuRes == 0) {
            throw new IllegalArgumentException("menuRes 不能为 0，必须传一个有效的 @menu 资源 id，例如 R.menu.stepos_call_bottom_nav");
        }
        XmlResourceParser xmlResourceParserOpenMenuResource = openMenuResource(context, menuRes);
        try {
            List<ParsedTabMenuItem> menu = INSTANCE.parseMenu(context, xmlResourceParserOpenMenuResource, menuRes);
            C4946a.a(xmlResourceParserOpenMenuResource, null);
            return menu;
        } finally {
        }
    }
}
