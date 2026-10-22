package ah8;

import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import ei9.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements hi9.a<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, String> f3437b;

    public b() {
        this.f3437b = new LinkedHashMap();
    }

    @Override // hi9.a
    public final boolean a(f r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return true;
    }

    @Override // hi9.a
    public final int b(f r100) {
        c r101 = (c) r100;
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Message r102 = r101.f563233a;
        WidgetRenderDelegate r103 = WidgetRenderDelegate.f297181a;
        String r104 = r102.getMessageId();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        String r105 = r103.b(r104, r102.getContent());
        Iterator r106 = ((LinkedHashMap) this.f3437b).values().iterator();
    L7:
        if (r106.hasNext() == false) goto L11;
        Object r107 = r106.next();
        if (Intrinsics.areEqual((String) r107, r105) == false) goto L7;
    L13:
        if (((String) r107) != null) goto L15;
        int r108 = this.f3436a + 1;
        this.f3436a = r108;
        this.f3437b.put(Integer.valueOf(r108), r105);
    L15:
        Iterator r109 = ((LinkedHashMap) this.f3437b).entrySet().iterator();
    L17:
        if (r109.hasNext() == false) goto L23;
        Map.Entry r110 = (Map.Entry) r109.next();
        if (Intrinsics.areEqual(r110.getValue(), r105) == false) goto L17;
        return ((Number) r110.getKey()).intValue();
    L23:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L11:
        r107 = null;
        goto L13
    }
}
