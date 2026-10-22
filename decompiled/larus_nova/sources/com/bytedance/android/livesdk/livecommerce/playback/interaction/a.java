package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/a;", "Lcom/bytedance/android/ec/model/g;", "", "Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/d;", "content", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends g {

    @SerializedName("interaction")
    private final List<d> content;

    public final List<e> a() {
        if (this.content == null) goto L5;
        ArrayList r100 = new ArrayList();
        Iterator<d> r101 = this.content.iterator();
    L8:
        if (r101.hasNext() == false) goto L43;
        d r102 = r101.next();
        List<f> r103 = r102.a();
        if (r103 == null) goto L8;
        SpannableStringBuilder r110 = new SpannableStringBuilder();
        ArrayList r111 = new ArrayList();
        e r112 = new e();
        Iterator<f> r104 = r103.iterator();
    L12:
        int r113 = 0;
        if (r104.hasNext() == false) goto L36;
        f r105 = r104.next();
        int r106 = r105.c();
        if (r106 != 1) goto L17;
        String r107 = r105.a();
        if (com.bytedance.android.shopping.anchorv3.a.b(r107) == true) goto L33;
        r107 = null;
    L33:
        if (r107 == null) goto L12;
        r111.add(r107);
        goto L12
    L17:
        if (r106 != 2) goto L19;
        String r108 = r105.d();
        if (r108 == null) goto L12;
        r110.append(r108);
        if (com.bytedance.android.shopping.anchorv3.a.b(r105.e()) == false) goto L12;
        int r109 = s.f45717a;
        r110.setSpan(new ForegroundColorSpan(s.a(r105.e(), -1)), StringsKt.indexOf$default(r110, r108, 0, false, 6, null), r110.length(), 0);
        goto L12
    L19:
        if (r106 != 3) goto L12;
        int r114 = r105.b();
    L22:
        if (r113 >= r114) goto L12;
        r110.append(" ");
        r113 = r113 + 1;
        goto L22
    L36:
        if ((!r111.isEmpty()) == true) goto L38;
    L42:
        r112.f149900a = r102.getType();
        r112.f149901b = r110;
        r112.f149902c = r111;
        r100.add(r112);
        goto L8
    L38:
        if (r111.size() <= 1) goto L40;
        int r115 = UtilityKotlinExtentionsKt.d(34);
    L41:
        r110.setSpan(new LeadingMarginSpan.Standard(r115, 0), 0, r110.length(), 0);
        goto L42
    L40:
        r115 = UtilityKotlinExtentionsKt.d(20);
        goto L41
    L43:
        return r100;
    L5:
        return new ArrayList();
    }

    public a() {
    }
}
