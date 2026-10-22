package b72;

import am2.x;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.j;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.l1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17907a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17911d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17912e;

        public a() {
        }

        public final String toString() {
            return "InputCheckResult{validEndIndex=" + this.f17908a + ", totalCount=" + this.f17909b + ", emojiCount=" + this.f17910c + ", liveEmojiCount=" + this.f17911d + ", liveAssociateImageCount=" + this.f17912e + ", length=0}";
        }
    }

    static {
    }

    public static a a(Editable r110, int r111) {
        if (r110 == null) goto L65;
        String r100 = r110.toString();
        a r101 = new a();
        int r102 = 0;
        e90.a[] r103 = (e90.a[]) r110.getSpans(0, r100.length(), e90.a.class);
        if (r103 != null) goto L7;
    L13:
        List r104 = null;
        e90.a r105 = null;
        int r106 = 0;
    L14:
        char[] r107 = r100.toCharArray();
        int r108 = r106;
        e90.a r109 = r105;
        int r112 = 0;
    L16:
        if (r102 >= r100.length()) goto L59;
        if (l1.b(r107[r102]) == false) goto L25;
        int r113 = r102 + 1;
        if (r113 < r100.length()) goto L22;
    L24:
        r102 = r113;
    L56:
        if (r101.f17909b > r111) goto L16;
        r101.f17908a = r102;
        goto L16
    L22:
        if (l1.b(r107[r113]) == false) goto L24;
        r101.f17909b++;
        r101.f17910c++;
        r102 = r102 + 2;
        goto L56
    L25:
        if (r109 == null) goto L54;
        if (r104 == null) goto L54;
        if (r102 != r108) goto L54;
        int r114 = r109.a();
        if (r114 != 1) goto L31;
    L46:
        r101.f17909b++;
        r101.f17911d++;
        if (r109.getDesc() == null) goto L49;
        String r115 = r109.getDesc();
        Intrinsics.checkNotNull(r115);
        int r116 = r115.length();
    L50:
        r102 = r102 + r116;
        r112 = r112 + 1;
        if (r112 >= r104.size()) goto L53;
        r109 = (e90.a) ListProtector.get(r104, r112);
        r108 = r110.getSpanStart(r109);
        goto L56
    L53:
        r109 = null;
    L49:
        r116 = 4;
        goto L50
    L31:
        if (r114 == 2) goto L46;
        if (r114 != 3) goto L35;
        r101.f17909b++;
        r101.f17912e++;
        if (r109.getDesc() == null) goto L49;
        String r117 = r109.getDesc();
        Intrinsics.checkNotNull(r117);
        r116 = r117.length();
        goto L50
    L35:
        if (r114 == 5) goto L37;
        r101.f17909b++;
        r116 = 1;
        goto L50
    L37:
        r101.f17909b++;
        r101.f17912e++;
        if ((r109 instanceof com.bytedance.android.livesdk.interactivity.comment.input.c) == true) goto L40;
        r109 = null;
    L40:
        com.bytedance.android.livesdk.interactivity.comment.input.c r118 = (com.bytedance.android.livesdk.interactivity.comment.input.c) r109;
        if (r118 == null) goto L49;
        r116 = r118.c().length();
    L54:
        r101.f17909b++;
        r102 = r102 + 1;
        goto L56
    L59:
        return r101;
    L7:
        if (r103.length != 0) goto L9;
        boolean r119 = true;
    L11:
        if ((!r119) == false) goto L13;
        r104 = ArraysKt.sortedWith(r103, new d(r110));
        r105 = (e90.a) ListProtector.get(r104, 0);
        r106 = r110.getSpanStart(r105);
        goto L14
    L9:
        r119 = false;
        goto L11
    L65:
        return null;
    }

    public static void b(j r100, com.bytedance.android.live.base.model.message.h r110, String r111, String r112, EditText r113) {
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());
        Bitmap r101 = Bitmap.createBitmap(r100.getMeasuredWidth(), r100.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        r100.draw(new Canvas(r101));
        BitmapDrawable r102 = new BitmapDrawable(r100.getResources(), r101);
        int r103 = s1.f(24.0f);
        com.bytedance.android.livesdk.interactivity.comment.input.d r104 = new com.bytedance.android.livesdk.interactivity.comment.input.d(r102, r110, r111, (int) ((r101.getWidth() / (r101.getHeight() + 0.0f)) * r103), r103);
        String r105 = r111 + r110.c();
        SpannableStringBuilder r114 = new SpannableStringBuilder(r105);
        if (r105 == null) goto L5;
        Integer r106 = Integer.valueOf(r105.length());
    L6:
        r114.setSpan(r104, 0, r106.intValue(), 33);
        Editable r107 = r113.getEditableText();
        if (r107 == null) goto L14;
        e90.a[] r108 = (e90.a[]) r107.getSpans(0, r107.length(), e90.a.class);
        int r109 = r108.length;
        int r115 = 0;
    L9:
        if (r115 >= r109) goto L14;
        if (r108[r115].a() == 7) goto L12;
        r115 = r115 + 1;
        goto L9
    L12:
        r107.clear();
    L14:
        Editable r116 = r113.getEditableText();
        if (r116 == null) goto L44;
        e90.a[] r117 = (e90.a[]) r116.getSpans(0, r116.length(), e90.a.class);
        int r118 = r117.length;
        int r119 = 0;
    L17:
        if (r119 >= r118) goto L22;
        e90.a r120 = r117[r119];
        if (r120.a() == 6) goto L23;
        r119 = r119 + 1;
    L23:
        if (r120 == null) goto L25;
        int r121 = r116.getSpanStart(r120);
        r116.delete(r121, r116.getSpanEnd(r120));
        r116.insert(r121, r114);
    L26:
        com.bytedance.android.livesdk.interactivity.comment.utils.a.f(r110, r112, true);
        Intrinsics.checkNotNullParameter(r110, "emoji");
        Intrinsics.checkNotNullParameter(r112, "clickArea");
        HashMap r122 = new HashMap();
        r122.put("emoji_type", "quick_interaction");
        if (r110.getType() != 1) goto L29;
        String r123 = "say_hi";
    L30:
        r122.put("quick_interaction_type", r123);
        r122.put("quick_interaction_source", r112);
        MiddlewareRoomContext r124 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r124 == null) goto L37;
        i<Boolean> r125 = r124.isAnchor();
        if (r125 == null) goto L37;
        if (r125.getValue().booleanValue() != true) goto L37;
        String r126 = "1";
    L38:
        r122.put(IPerformanceManager.Params.is_anchor, r126);
        j0.l().sendLog("livesdk_input_box_quick_interaction_show", r122, new Object[]{x.class, IRoom.class});
        return;
    L37:
        r126 = "0";
        goto L38
    L29:
        r123 = "location";
        goto L30
    L25:
        r116.insert(r113.getSelectionStart(), r114);
        goto L26
    L22:
        r120 = null;
        goto L23
    L44:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
