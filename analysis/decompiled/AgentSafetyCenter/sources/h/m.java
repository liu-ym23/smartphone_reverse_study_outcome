package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.LocaleList;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4852c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Context f4853f;

    public /* synthetic */ m(int i) {
        this.f4852c = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException, IOException {
        Object systemService;
        j3.c cVar;
        String attributeValue;
        Context context;
        int i = this.f4852c;
        Context context2 = this.f4853f;
        switch (i) {
            case 0:
                ComponentName componentName = new ComponentName(context2, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                if (context2.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                    p.f fVar = q.i;
                    fVar.getClass();
                    p.a aVar = new p.a(fVar);
                    while (true) {
                        if (aVar.hasNext()) {
                            q qVar = (q) ((WeakReference) aVar.next()).get();
                            if (qVar != null && (context = ((e0) qVar).f4794l) != null) {
                                systemService = context.getSystemService("locale");
                            }
                        } else {
                            systemService = null;
                        }
                    }
                    if (systemService != null) {
                        LocaleList localeListA = o.a(systemService);
                        j3.d dVar = new j3.d();
                        dVar.f6551a = localeListA;
                        VarHandle.storeStoreFence();
                        cVar = new j3.c();
                        cVar.f6550a = dVar;
                        VarHandle.storeStoreFence();
                    } else {
                        cVar = j3.c.f6549b;
                    }
                    if (cVar.f6550a.f6551a.isEmpty()) {
                        synchronized (d3.a.f3184a) {
                            attributeValue = "";
                            try {
                                FileInputStream fileInputStreamOpenFileInput = context2.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                                try {
                                    try {
                                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                                        int depth = xmlPullParserNewPullParser.getDepth();
                                        while (true) {
                                            int next = xmlPullParserNewPullParser.next();
                                            if (next != 1 && (next != 3 || xmlPullParserNewPullParser.getDepth() > depth)) {
                                                if (next != 3 && next != 4 && xmlPullParserNewPullParser.getName().equals("locales")) {
                                                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "application_locales");
                                                }
                                            }
                                        }
                                    } catch (IOException | XmlPullParserException unused) {
                                        Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                                        if (fileInputStreamOpenFileInput != null) {
                                        }
                                    }
                                    if (fileInputStreamOpenFileInput != null) {
                                        try {
                                            fileInputStreamOpenFileInput.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    if (attributeValue.isEmpty()) {
                                        context2.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                                    }
                                } finally {
                                }
                            } catch (FileNotFoundException unused3) {
                            }
                        }
                        Object systemService2 = context2.getSystemService("locale");
                        if (systemService2 != null) {
                            o.b(systemService2, n.a(attributeValue));
                        }
                    }
                    context2.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                }
                q.f4888h = true;
                return;
            case 1:
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
                m mVar = new m(2);
                mVar.f4853f = context2;
                VarHandle.storeStoreFence();
                threadPoolExecutor.execute(mVar);
                return;
            default:
                m4.f.u(context2, new m4.d(0), m4.f.f8217a, false);
                return;
        }
    }
}
