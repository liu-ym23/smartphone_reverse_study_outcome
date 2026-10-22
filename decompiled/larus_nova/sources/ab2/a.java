package ab2;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.service.emoji.model.EmojiUriModel;
import com.bytedance.android.livesdk.interactivity.service.emoji.model.EmojiUriNode;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2469a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(String r100) {
        int r101 = fb2.a.f476250a;
        if (TextUtils.isEmpty(r100) == true) goto L54;
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L36
        Matcher r103 = PatternProtector.compile("(?:[\\uD83C\\uDF00-\\uD83D\\uDDFF]|[\\uD83E\\uDD00-\\uD83E\\uDDFF]|[\\uD83D\\uDE00-\\uD83D\\uDE4F]|[\\uD83D\\uDE80-\\uD83D\\uDEFF]|[\\u2600-\\u26FF]\\uFE0F?|[\\u2700-\\u27BF]\\uFE0F?|\\u24C2\\uFE0F?|[\\uD83C\\uDDE6-\\uD83C\\uDDFF]{1,2}|[\\uD83C\\uDD70\\uD83C\\uDD71\\uD83C\\uDD7E\\uD83C\\uDD7F\\uD83C\\uDD8E\\uD83C\\uDD91-\\uD83C\\uDD9A]\\uFE0F?|[\\u0023\\u002A\\u0030-\\u0039]\\uFE0F?\\u20E3|[\\u2194-\\u2199\\u21A9-\\u21AA]\\uFE0F?|[\\u2B05-\\u2B07\\u2B1B\\u2B1C\\u2B50\\u2B55]\\uFE0F?|[\\u2934\\u2935]\\uFE0F?|[\\u3030\\u303D]\\uFE0F?|[\\u3297\\u3299]\\uFE0F?|[\\uD83C\\uDE01\\uD83C\\uDE02\\uD83C\\uDE1A\\uD83C\\uDE2F\\uD83C\\uDE32-\\uD83C\\uDE3A\\uD83C\\uDE50\\uD83C\\uDE51]\\uFE0F?|[\\u203C\\u2049]\\uFE0F?|[\\u25AA\\u25AB\\u25B6\\u25C0\\u25FB-\\u25FE]\\uFE0F?|[\\u00A9\\u00AE]\\uFE0F?|[\\u2122\\u2139]\\uFE0F?|\\uD83C\\uDC04\\uFE0F?|\\uD83C\\uDCCF\\uFE0F?|[\\u231A\\u231B\\u2328\\u23CF\\u23E9-\\u23F3\\u23F8-\\u23FA]\\uFE0F?)").matcher(r100);     // Catch: Exception -> L36
    L7:
        if (r103.find() == false) goto L11;
        r102.add(r103.group());     // Catch: Exception -> L36
        if (r102.size() <= 3) goto L7;
        return false;
    L11:
        int r104 = r102.size();     // Catch: Exception -> L36
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r104) goto L14;
        r106 = r106 + ((String) ListProtector.get(r102, r105)).length();     // Catch: Exception -> L36
        r105 = r105 + 1;     // Catch: Exception -> L36
        goto L12
    L14:
        Intrinsics.checkNotNull(r100);     // Catch: Exception -> L36
        if (r106 == r100.length()) goto L17;
        Matcher r107 = PatternProtector.compile("(\\[)([^\\[\\]]+)(])").matcher(r100);     // Catch: Exception -> L36
    L21:
        if (r107.find() == false) goto L27;
        String r108 = r107.group();     // Catch: Exception -> L36
        if (((IMiddleWareHostEmoji) k.n(IMiddleWareHostEmoji.class)).getRealDrawable(r108) == null) goto L21;
        r102.add(r108);     // Catch: Exception -> L36
        if (r102.size() <= 3) goto L21;
        return false;
    L27:
        int r109 = r102.size();     // Catch: Exception -> L36
        int r110 = 0;
        int r111 = 0;
    L28:
        if (r110 >= r109) goto L31;
        r111 = r111 + ((String) ListProtector.get(r102, r110)).length();     // Catch: Exception -> L36
        r110 = r110 + 1;     // Catch: Exception -> L36
        goto L28
    L31:
        if (r111 == r100.length()) goto L33;
        return false;
    L33:
        if (r102.size() > 3) goto L53;
    L34:
        return true;
    L53:
        return false;
    L17:
        if (r102.size() <= 3) goto L34;
        return false;
    L55:
        return false;
    L54:
        return false;
    }

    @JvmStatic
    public static final void c(Spannable r110) {
        bb2.a r100 = b.a().f2472b;
        r100.getClass();
        ArrayList r101 = new ArrayList();
        Matcher r102 = bb2.a.f18529b.matcher(r110);     // Catch: Exception -> L65
    L5:
        if (r102.find() == false) goto L35;
        String r103 = r102.group();
        int r104 = r102.start();
        int r105 = r102.end();
        List<BaseEmoji> r106 = r100.f18530a;
        if (r106 != null) goto L9;
    L10:
        r100.f18530a = ((IMiddleWareHostEmoji) k.f(IMiddleWareHostEmoji.class)).loadAllBaseEmoji();
    L11:
        List<BaseEmoji> r107 = r100.f18530a;
        if (r107 != null) goto L14;
    L32:
        EmojiUriModel r108 = null;
    L33:
        if (r108 == null) goto L5;
        r101.add(new EmojiUriNode(r108, r104, r105));
        goto L5
    L14:
        if (r107.isEmpty() == true) goto L32;
        Iterator<BaseEmoji> r109 = r107.iterator();
    L18:
        if (r109.hasNext() == false) goto L32;
        BaseEmoji r111 = r109.next();
        if (TextUtils.equals(r111.getDescription(), r103) == false) goto L18;
        int r112 = r111.getIconId();
        String r113 = r111.getLocalFilePath();
        if (r112 > 0) goto L24;
        if (r113 == null) goto L18;
        if (r113.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L29;
    L31:
        r108 = new EmojiUriModel(r112, r113, r103);
        goto L33
    L29:
        if (r113.startsWith("file:///") == true) goto L31;
        r113 = r113.replace(MSkiaImageRegionDecoder.FILE_PREFIX, "file:///");
        goto L31
    L24:
        r108 = new EmojiUriModel(r112, r113, r103);
        goto L33
    L9:
        if (r106.isEmpty() == false) goto L11;
    L35:
        Iterator r114 = r101.iterator();
    L37:
        if (r114.hasNext() == false) goto L64;
        EmojiUriNode r115 = (EmojiUriNode) r114.next();
        EmojiUriModel r116 = r115.getEmojiUri();
        if (r116 == null) goto L37;
        int r117 = r115.getStartIndex();
        int r118 = r115.getEndIndex();
        if (r110 == null) goto L37;
        if (r110.length() == 0) goto L37;
        if (r117 < 0) goto L37;
        if (r117 > r110.length()) goto L37;
        if (r117 > r118) goto L37;
        if (r118 > r110.length()) goto L37;
        if (r116.getLocalFilePath() == null) goto L58;
        if (r116.getLocalFilePath().startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L58;
        String r119 = r116.getLocalFilePath();
    L61:
        if (r119 == null) goto L37;
        r110.setSpan(new ImageSpan(new ColorDrawable(), r119), r117, r118, 33);
    L58:
        if (r116.getIconId() <= 0) goto L60;
        r119 = String.format(Locale.CHINESE, "%s%d", new Object[]{"res://", Integer.valueOf(r116.getIconId())});
        goto L61
    L60:
        r119 = null;
        goto L61
    }

    @JvmStatic
    public static final List<db2.a> d(CharSequence r100) {
        return b.a().f2472b.b(r100);
    }

    @JvmStatic
    public static final void b(Spannable r100, int r110) {
        Iterator r101 = ((ArrayList) b.a().f2472b.b(r100)).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        db2.a r102 = (db2.a) r101.next();
        Drawable r103 = r102.f467796a;
        if (r103 == null) goto L4;
        bb2.a.a(r100, r103, r102.f467797b, r102.f467798c, r110, r110, null);
        goto L4
    }

    @JvmStatic
    public static final void e(SpannableString r100, int r101) {
        b.a().b(r100, r101);
    }

    @JvmStatic
    public static final SpannableString f(CharSequence r100, float r101) {
        return b.a().c(r100, r101);
    }
}
