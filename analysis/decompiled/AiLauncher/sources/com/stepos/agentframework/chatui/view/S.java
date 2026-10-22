package com.stepos.agentframework.chatui.view;

import Z8.C1173v;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$string;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatui/view/S;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "Lkotlin/Function0;", "LY8/t;", "onClick", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Lp9/a;)V", Const.INTENT_KEY_UMID, "(Ljava/util/List;)V", "Landroid/widget/TextView;", "titleText", "Landroid/widget/TextView;", "iconsContainer", "Landroid/widget/LinearLayout;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public final class S extends LinearLayout {
    private static final int ICON_OVERLAP_DP = 6;
    private static final int ICON_SIZE_DP = 16;
    private static final int MAX_ICON_COUNT = 3;
    private final LinearLayout iconsContainer;
    private final TextView titleText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(Context context) {
        super(context, null);
        kotlin.jvm.internal.p.i(context, "context");
        setOrientation(0);
        setGravity(16);
        setBackground(androidx.core.content.a.e(context, R$drawable.bg_sources_capsule));
        O6.d dVar = O6.d.INSTANCE;
        setPadding(dVar.a(context, 12.0f), dVar.a(context, 6.0f), dVar.a(context, 10.0f), dVar.a(context, 6.0f));
        TextView textView = new TextView(context);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(androidx.core.content.a.c(context, R$color.agent_text_primary));
        textView.setTextSize(13.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.titleText = textView;
        addView(textView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.iconsContainer = linearLayout;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = dVar.a(context, 6.0f);
        Y8.t tVar = Y8.t.f7040a;
        addView(linearLayout, layoutParams);
    }

    public static final void c(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public final void b(List<ReferenceSource> sources, final InterfaceC5063a<Y8.t> onClick) {
        kotlin.jvm.internal.p.i(sources, "sources");
        kotlin.jvm.internal.p.i(onClick, "onClick");
        this.titleText.setText(getContext().getString(R$string.chat_sources_count, Integer.valueOf(sources.size())));
        setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                S.c(onClick, view);
            }
        });
        d(sources);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    public final void d(List<ReferenceSource> sources) {
        this.iconsContainer.removeAllViews();
        if (sources.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList(3);
        for (ReferenceSource referenceSource : sources) {
            String iconUrl = referenceSource.getIconUrl();
            if (La.H.x0(iconUrl)) {
                iconUrl = referenceSource.getSiteName();
            }
            if (iconUrl.length() > 0 && hashSet.add(iconUrl)) {
                arrayList.add(referenceSource);
                if (arrayList.size() >= 3) {
                    break;
                }
            }
        }
        boolean zIsEmpty = arrayList.isEmpty();
        ArrayList arrayListF1 = arrayList;
        if (zIsEmpty) {
            arrayListF1 = Z8.F.f1(sources, 1);
        }
        O6.d dVar = O6.d.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        int iA = dVar.a(context, 16.0f);
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        int iA2 = dVar.a(context2, 6.0f);
        int i10 = 0;
        for (Object obj : arrayListF1) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            ReferenceSource referenceSource2 = (ReferenceSource) obj;
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int i12 = R$drawable.ic_source_globe;
            imageView.setImageResource(i12);
            imageView.setElevation(arrayListF1.size() - i10);
            imageView.setForeground(androidx.core.content.a.e(imageView.getContext(), R$drawable.bg_source_icon_stroke));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA);
            if (i10 > 0) {
                layoutParams.leftMargin = -iA2;
            }
            this.iconsContainer.addView(imageView, layoutParams);
            if (!La.H.x0(referenceSource2.getIconUrl())) {
                Glide.with(imageView).load(referenceSource2.getIconUrl()).placeholder(i12).error(i12).transform(new CircleCrop()).into(imageView);
            }
            i10 = i11;
        }
    }
}
