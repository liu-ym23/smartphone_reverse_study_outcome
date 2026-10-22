package com.bytedance.android.livesdk.revenue.service.ui;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
public interface IRevFloatingBannerManager extends dy0.b {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/ui/IRevFloatingBannerManager$Element;", "", "PublicScreen", "EntryAnim", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Element extends Enum<Element> {
        public static final Element EntryAnim = null;
        public static final Element PublicScreen = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Element[] f157477a = null;

        static {
            Element r100 = new Element("PublicScreen", 0);
            PublicScreen = r100;
            Element r101 = new Element("EntryAnim", 1);
            EntryAnim = r101;
            f157477a = new Element[]{r100, r101};
        }

        public static Element valueOf(String r100) {
            return (Element) r27.a.a(Element.class, r100);
        }

        public static Element[] values() {
            return (Element[]) f157477a.clone();
        }

        public Element(String r100, int r101) {
            super(r100, r101);
        }
    }

    void H1(View r100);

    void n0(View r100);

    void se(View r100, View r101, Element r102);
}
