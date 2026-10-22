package bb2;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jc1.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f18529b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<BaseEmoji> f18530a;

    static {
        f18529b = PatternProtector.compile("\\[[a-zA-Z0-9\\u4e00-\\u9fa5]+\\]");
    }

    public a() {
        this.f18530a = null;
    }

    public static List c(CharSequence r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L23:
        return r101;
    L5:
        if (r100.length() < 3) goto L23;
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
        boolean r104 = false;
        int r105 = 0;
    L9:
        if (r103 >= r100.length()) goto L23;
        char r106 = r100.charAt(r103);
        if (r106 != '[') goto L14;
        r102.setLength(0);
        r102.append('[');
        r104 = true;
        r105 = r103;
    L22:
        r103 = r103 + 1;
        goto L9
    L14:
        if (r106 != ']') goto L20;
        if (r104 == false) goto L20;
        r102.append(']');
        Drawable r107 = ((IMiddleWareHostEmoji) k.f(IMiddleWareHostEmoji.class)).getRealDrawable(r102.toString());
        if (r107 == null) goto L19;
        r101.add(new db2.a(r107, r105, r103 + 1));
    L19:
        r102.setLength(0);
        r104 = false;
    L20:
        if (r104 == false) goto L22;
        r102.append(r106);
        goto L22
    }

    public final List<db2.a> b(CharSequence r100) {
        ArrayList r101 = new ArrayList();
        Matcher r102 = f18529b.matcher(r100);     // Catch: Exception -> L10
    L5:
        if (r102.find() == false) goto L9;
        String r103 = r102.group();
        int r104 = r102.start();
        int r105 = r102.end();
        Drawable r106 = ((IMiddleWareHostEmoji) k.f(IMiddleWareHostEmoji.class)).getRealDrawable(r103);
        if (r106 == null) goto L5;
        r101.add(new db2.a(r106, r104, r105));
    L9:
        return r101;
    }

    public static void a(Spannable r100, Drawable r101, int r102, int r103, int r104, int r105, String r106) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() == 0) goto L15;
        if (r102 >= 0) goto L7;
        return;
    L7:
        if (r102 > r100.length()) goto L17;
        if (r102 <= r103) goto L10;
        return;
    L10:
        if (r103 > r100.length()) goto L19;
        r101.setBounds(0, 0, r104, r105);
        eb2.a r107 = new eb2.a(r101);
        r107.f471795a = 2;
        r107.f471796b = 2;
        r107.f471797c = r106;
        r100.setSpan(r107, r102, r103, 33);
        return;
    L19:
        return;
    L17:
        return;
    }
}
