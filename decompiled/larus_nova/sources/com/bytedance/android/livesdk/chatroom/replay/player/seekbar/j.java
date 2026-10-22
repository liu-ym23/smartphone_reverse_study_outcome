package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplaySeekBar f109745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f109746b;

    public j(ReplaySeekBar r100, List r101) {
        this.f109745a = r100;
        this.f109746b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        LinkedHashMap r111 = new LinkedHashMap();
        List r100 = this.f109746b;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L11;
        T r104 = r102.next();
        if (((com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r104).f118429m == 3) goto L9;
        r103 = false;
    L9:
        if (r103 == false) goto L3;
        r101.add(r104);
        goto L3
    L11:
        Iterator<T> r105 = r101.iterator();
    L13:
        if (r105.hasNext() == false) goto L20;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.e r106 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.e) r105.next();
        r111.put(r106.f118421e, Boolean.TRUE);
        if (this.f109745a.Q1.containsKey(r106.f118421e) == true) goto L13;
        HSImageView r107 = new HSImageView(this.f109745a.getContext());
        r107.setLayoutParams(new ViewGroup.LayoutParams((int) this.f109745a.getMImageMarkSizePx(), (int) this.f109745a.getMImageMarkSizePx()));
        r107.setVisibility(8);
        this.f109745a.Q1.put(r106.f118421e, r107);
        py.k r108 = r106.f118427k;
        if (r108 == null) goto L13;
        ImageUtil.loadImage(r107, r108, (int) this.f109745a.getMImageMarkSizePx(), (int) this.f109745a.getMImageMarkSizePx(), true, 0, ImageView.ScaleType.FIT_CENTER, null);
        goto L13
    L20:
        Map<String, HSImageView> r109 = this.f109745a.Q1;
        LinkedHashMap r112 = new LinkedHashMap();
        Iterator r113 = ((LinkedHashMap) r109).entrySet().iterator();
    L22:
        if (r113.hasNext() == false) goto L26;
        Map.Entry r114 = (Map.Entry) r113.next();
        if ((!Intrinsics.areEqual((Boolean) r111.get((String) r114.getKey()), Boolean.TRUE)) == false) goto L22;
        r112.put(r114.getKey(), r114.getValue());
        goto L22
    L26:
        Iterator r115 = r112.entrySet().iterator();
    L28:
        if (r115.hasNext() == false) goto L30;
        Map.Entry r116 = (Map.Entry) r115.next();
        String r117 = (String) r116.getKey();
        this.f109745a.removeView((HSImageView) r116.getValue());
        this.f109745a.Q1.remove(r117);
        goto L28
    L30:
        ((ArrayList) this.f109745a.S1).clear();
    }
}
