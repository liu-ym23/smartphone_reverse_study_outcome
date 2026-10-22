package com.stepos.ailauncher.foundation.appstore.api;

import La.D;
import La.H;
import N5.j;
import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000\u001a\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"toAppVersionPage", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionPage;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionListDto;", "CATEGORY_APP", "", "toAppVersionItems", "", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDto;", "toAppVersionSearchPage", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionSearchPage;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionSearchDto;", "httpsOf", "", "url", "toAppVersionDetail", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetail;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetailDto;", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppVersionListApiKt {
    private static final int CATEGORY_APP = 1;

    private static final String httpsOf(String str) {
        String strD = j.INSTANCE.d(str);
        if (strD == null) {
            return null;
        }
        if (!D.X(strD, "http://", false, 2, null)) {
            return strD;
        }
        return "https://" + H.R0(strD, "http://");
    }

    public static final AppVersionDetail toAppVersionDetail(AppVersionDetailDto appVersionDetailDto) {
        AppVersionQualityLabelDto qualityLabel;
        p.i(appVersionDetailDto, "<this>");
        long id = appVersionDetailDto.getId();
        j jVar = j.INSTANCE;
        String strD = jVar.d(appVersionDetailDto.getName());
        String strD2 = jVar.d(appVersionDetailDto.getPackageName());
        String strD3 = jVar.d(appVersionDetailDto.getPublisher());
        String strD4 = jVar.d(appVersionDetailDto.getCategoryName());
        String strD5 = jVar.d(appVersionDetailDto.getDescription());
        String strD6 = jVar.d(appVersionDetailDto.getRecommendDesc());
        String strD7 = jVar.d(appVersionDetailDto.getVersionName());
        int versionCode = appVersionDetailDto.getVersionCode();
        long versionTime = appVersionDetailDto.getVersionTime();
        long size = appVersionDetailDto.getSize();
        String strHttpsOf = httpsOf(appVersionDetailDto.getIcon());
        List<AppVersionImageDto> images = appVersionDetailDto.getImages();
        if (images == null) {
            images = C1173v.m();
        }
        List<AppVersionImageDto> list = images;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String strHttpsOf2 = httpsOf(((AppVersionImageDto) it.next()).getImage());
            if (strHttpsOf2 != null) {
                arrayList.add(strHttpsOf2);
            }
        }
        long downloadCount = appVersionDetailDto.getDownloadCount();
        long evaluateCount = appVersionDetailDto.getEvaluateCount();
        double avgScore = appVersionDetailDto.getAvgScore();
        int star = appVersionDetailDto.getStar();
        AppVersionQualityLabelDto qualityLabel2 = appVersionDetailDto.getQualityLabel();
        boolean z10 = true;
        if ((qualityLabel2 == null || qualityLabel2.getOfficial() != 1) && (((qualityLabel = appVersionDetailDto.getQualityLabel()) == null || qualityLabel.getSuperior() != 1) && appVersionDetailDto.getIcpStatus() != 1)) {
            z10 = false;
        }
        return new AppVersionDetail(id, strD, strD2, strD3, strD4, strD5, strD6, strD7, versionCode, versionTime, size, strHttpsOf, arrayList, downloadCount, evaluateCount, avgScore, star, z10, appVersionDetailDto.getStatus());
    }

    private static final List<AppVersionItem> toAppVersionItems(List<AppVersionDto> list) {
        if (list == null) {
            list = C1173v.m();
        }
        ArrayList<AppVersionDto> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((AppVersionDto) obj).getCategory() == 1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (AppVersionDto appVersionDto : arrayList) {
            long id = appVersionDto.getId();
            j jVar = j.INSTANCE;
            arrayList2.add(new AppVersionItem(id, jVar.d(appVersionDto.getName()), jVar.d(appVersionDto.getPackageName()), httpsOf(appVersionDto.getIcon()), jVar.d(appVersionDto.getRecommendDesc()), jVar.d(appVersionDto.getPublisher()), appVersionDto.getSize(), appVersionDto.getDownloadCount()));
        }
        return arrayList2;
    }

    public static final AppVersionPage toAppVersionPage(AppVersionListDto appVersionListDto) {
        List<AppVersionDto> data;
        p.i(appVersionListDto, "<this>");
        if (appVersionListDto.getMore() && ((data = appVersionListDto.getData()) == null || data.isEmpty())) {
            throw new IllegalStateException("Empty app version page with more=true");
        }
        return new AppVersionPage(toAppVersionItems(appVersionListDto.getData()), appVersionListDto.getPage(), appVersionListDto.getTotal(), appVersionListDto.getMore());
    }

    public static final AppVersionSearchPage toAppVersionSearchPage(AppVersionSearchDto appVersionSearchDto) {
        List<AppVersionDto> data;
        p.i(appVersionSearchDto, "<this>");
        if (appVersionSearchDto.getMore() && (appVersionSearchDto.getPageSize() <= 0 || (data = appVersionSearchDto.getData()) == null || data.isEmpty())) {
            throw new IllegalStateException("App search page did not advance");
        }
        return new AppVersionSearchPage(toAppVersionItems(appVersionSearchDto.getData()), appVersionSearchDto.getMore(), appVersionSearchDto.getPageSize());
    }
}
