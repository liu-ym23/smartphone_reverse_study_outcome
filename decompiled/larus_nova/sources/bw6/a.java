package bw6;

import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.pdp.album.adapter.LoadMoreRecyclerViewAdapter;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.locallife.pdp.album.page.PictureAlbumFragment;
import com.bytedance.locallife.pdp.album.page.PictureRecyclerViewAdapter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements ho6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PictureAlbumFragment f21147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21148b;

    @Override // ho6.a
    public final boolean hasMore() {
        CustomAlbumViewModel r100 = this.f21147a.f260986d;
        if (r100 == null) goto L11;
        HashMap<String, AlbumPageInfo> r101 = r100.getAlbumInfo();
        if (r101 == null) goto L11;
        AlbumPageInfo r102 = r101.get(this.f21148b);
        if (r102 == null) goto L11;
        Boolean r103 = r102.getHasMore();
        if (r103 == null) goto L11;
        return r103.booleanValue();
    L11:
        return false;
    }

    @Override // ho6.a
    public final void preload() {
        CustomAlbumViewModel r100 = this.f21147a.f260986d;
        if (r100 == null) goto L5;
        r100.requestAlbumPage(this.f21148b, 4);
    L5:
        this.f21147a.f260989g = 4;
    }

    @Override // ho6.a
    public final void x1() {
        PictureRecyclerViewAdapter r100 = this.f21147a.f260990h;
        if (r100 == null) goto L9;
        LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r101 = r100.f260955h;
        if (r101 == null) goto L7;
        int r102 = LoadMoreRecyclerViewAdapter.LoadMoreViewHolder.f260957c;
        ((DmtStatusView) r101.itemView).e();
    L7:
        r100.f260949b = 1;
        return;
    }

    public a(PictureAlbumFragment r100, String r101) {
        this.f21147a = r100;
        this.f21148b = r101;
    }
}
