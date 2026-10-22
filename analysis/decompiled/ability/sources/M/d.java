package M;

import N9.j;
import android.view.View;
import com.volcengine.tos.model.object.DownloadPartInfo;
import com.volcengine.tos.model.object.UploadPartInfo;
import java.io.File;
import java.util.Comparator;
import java.util.Map;
import n1.C1738a;

/* loaded from: classes2.dex */
public final class d implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f951a;

    public /* synthetic */ d(int i) {
        this.f951a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f951a) {
            case 0:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 1:
                return String.CASE_INSENSITIVE_ORDER.compare((String) obj, (String) obj2);
            case 2:
                return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
            case 3:
                return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
            case 4:
                return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
            case 5:
                return String.CASE_INSENSITIVE_ORDER.compare((String) obj, (String) obj2);
            case 6:
                return ((File) obj).compareTo((File) obj2);
            case 7:
                return ((DownloadPartInfo) obj).getPartNumber() - ((DownloadPartInfo) obj2).getPartNumber();
            case 8:
                return ((UploadPartInfo) obj).getPartNumber() - ((UploadPartInfo) obj2).getPartNumber();
            case 9:
                return (int) ((((C1738a) obj2).f5344a * 100.0d) - (((C1738a) obj).f5344a * 100.0d));
            case 10:
                return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
            case 11:
                return ((View) obj).getTop() - ((View) obj2).getTop();
            case 12:
                return (int) ((((c1.c) obj2).d * 100.0d) - (((c1.c) obj).d * 100.0d));
            default:
                return j.m((Double) ((Map.Entry) obj2).getValue(), (Double) ((Map.Entry) obj).getValue());
        }
    }
}
