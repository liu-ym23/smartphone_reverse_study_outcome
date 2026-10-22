package com.bytedance.android.live.room.api.messagewindow.manager;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
public interface IFloatingBannerManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/manager/IFloatingBannerManager$Element;", "", "PublicScreen", "EntryAnim", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Element extends Enum<Element> {
        public static final Element EntryAnim = null;
        public static final Element PublicScreen = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Element[] f98992a = null;

        static {
            Element r100 = new Element("PublicScreen", 0);
            PublicScreen = r100;
            Element r101 = new Element("EntryAnim", 1);
            EntryAnim = r101;
            f98992a = new Element[]{r100, r101};
        }

        public static Element valueOf(String r100) {
            return (Element) a.a(Element.class, r100);
        }

        public static Element[] values() {
            return (Element[]) f98992a.clone();
        }

        public Element(String r100, int r101) {
            super(r100, r101);
        }
    }

    void H1(View r100);

    void I1(View r100, View r101, Element r102);

    ViewGroup getRootContainer();

    void n0(View r100);
}
