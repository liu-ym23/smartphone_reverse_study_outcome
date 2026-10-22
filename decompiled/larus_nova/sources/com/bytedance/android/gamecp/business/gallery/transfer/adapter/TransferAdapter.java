package com.bytedance.android.gamecp.business.gallery.transfer.adapter;

import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.gamecp.business.gallery.view.image.TransferImage;

/* JADX INFO: loaded from: classes44.dex */
public abstract class TransferAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f53234b;

    public interface a {
    }

    public abstract TransferImage f(int r100);

    public abstract FrameLayout g(int r100);

    public TransferAdapter() {
    }
}
