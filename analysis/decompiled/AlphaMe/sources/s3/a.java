package s3;

import B0.g;
import android.content.res.AssetManager;
import android.os.Trace;
import android.util.Log;
import androidx.appcompat.app.C0186l;
import androidx.appcompat.widget.C0238z;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;
import org.tensorflow.contrib.android.RunStats;
import r3.d;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Graph f14255a;

    /* renamed from: b, reason: collision with root package name */
    public final Session f14256b;

    /* renamed from: c, reason: collision with root package name */
    public C0238z f14257c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f14258d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f14259e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f14260f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public List f14261g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public RunStats f14262h;

    public a(AssetManager assetManager, String str) throws IOException {
        String str2;
        InputStream fileInputStream;
        Log.i("TensorFlowInferenceInterface", "Checking to see if TensorFlow native methods are already loaded");
        try {
            new RunStats();
            Log.i("TensorFlowInferenceInterface", "TensorFlow native methods already loaded");
        } catch (UnsatisfiedLinkError unused) {
            Log.i("TensorFlowInferenceInterface", "TensorFlow native methods not found, attempting to load via tensorflow_inference");
            try {
                System.loadLibrary("tensorflow_inference");
                Log.i("TensorFlowInferenceInterface", "Successfully loaded TensorFlow native methods (RunStats error may be ignored)");
            } catch (UnsatisfiedLinkError unused2) {
                throw new RuntimeException("Native TF methods not found; check that the correct native libraries are present in the APK.");
            }
        }
        Graph graph = new Graph();
        this.f14255a = graph;
        Session session = new Session(graph);
        this.f14256b = session;
        this.f14257c = session.b();
        boolean zStartsWith = str.startsWith("file:///android_asset/");
        if (zStartsWith) {
            try {
                str2 = str.split("file:///android_asset/")[1];
            } catch (IOException e4) {
                if (zStartsWith) {
                    throw new RuntimeException(g.n("Failed to load model from '", str, "'"), e4);
                }
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (IOException unused3) {
                    throw new RuntimeException(g.n("Failed to load model from '", str, "'"), e4);
                }
            }
        } else {
            str2 = str;
        }
        fileInputStream = assetManager.open(str2);
        try {
            d(fileInputStream, this.f14255a);
            fileInputStream.close();
            Log.i("TensorFlowInferenceInterface", "Successfully loaded model from '" + str + "'");
        } catch (IOException e5) {
            throw new RuntimeException(g.n("Failed to load model from '", str, "'"), e5);
        }
    }

    public static void d(InputStream inputStream, Graph graph) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Trace.beginSection("initializeTensorFlow");
        Trace.beginSection("readGraphDef");
        int iAvailable = inputStream.available();
        byte[] bArr = new byte[iAvailable];
        int i4 = inputStream.read(bArr);
        if (i4 != iAvailable) {
            throw new IOException(g.k("read error: read only ", i4, " of the graph, expected to read ", iAvailable));
        }
        Trace.endSection();
        Trace.beginSection("importGraphDef");
        try {
            graph.a(bArr);
            Trace.endSection();
            Trace.endSection();
            Log.i("TensorFlowInferenceInterface", "Model load took " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms, TensorFlow version: " + TensorFlow.version());
        } catch (IllegalArgumentException e4) {
            throw new IOException("Not a valid TensorFlow Graph serialization: " + e4.getMessage());
        }
    }

    public final void a() {
        ArrayList arrayList = this.f14259e;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Tensor) it.next()).close();
        }
        arrayList.clear();
        this.f14258d.clear();
    }

    public final void b() {
        Iterator it = this.f14261g.iterator();
        while (it.hasNext()) {
            ((Tensor) it.next()).close();
        }
        this.f14261g.clear();
        this.f14260f.clear();
    }

    public final void c(String str, float[] fArr, long... jArr) {
        Tensor tensorB = Tensor.b(jArr, FloatBuffer.wrap(fArr));
        C0186l c0186lD = C0186l.d(str);
        C0238z c0238z = this.f14257c;
        String str2 = (String) c0186lD.f2661c;
        int i4 = c0186lD.f2660b;
        ((ArrayList) c0238z.f3212a).add(new d(c0238z.e(str2), i4));
        ((ArrayList) c0238z.f3213b).add(tensorB);
        this.f14258d.add(str);
        this.f14259e.add(tensorB);
    }

    public final void finalize() throws Throwable {
        try {
            a();
            b();
            this.f14256b.close();
            this.f14255a.close();
            RunStats runStats = this.f14262h;
            if (runStats != null) {
                runStats.close();
            }
            this.f14262h = null;
        } finally {
            super.finalize();
        }
    }
}
