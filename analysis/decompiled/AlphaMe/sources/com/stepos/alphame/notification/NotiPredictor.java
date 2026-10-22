package com.stepos.alphame.notification;

import B0.c;
import B0.g;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.C0186l;
import androidx.appcompat.widget.C0238z;
import ch.qos.logback.classic.net.SyslogAppender;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.notification.Helpers.DataHelper;
import com.stepos.alphame.notification.Helpers.Word2VecLoader;
import com.stepos.alphame.notification.model.PredictVo;
import com.stepos.alphame.notification.model.TrainningParamsModel;
import com.stepos.alphame.notification.model.Word2VecModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.nio.FloatBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.tensorflow.Graph;
import org.tensorflow.Operation;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import r3.d;
import r3.e;
import s3.a;

/* loaded from: classes.dex */
public class NotiPredictor {
    private static final String PROB_EMIT = "/prob_emit.txt";
    private Graph graph;
    private Session session;
    private TrainningParamsModel params = DataHelper.paramLoader(getParamPath());
    private Word2VecModel w2vModel = Word2VecLoader.loadModel(getW2vModelPath());
    private List<String> stopwords = DataHelper.stopwordsLoader(getStopwordsPath());
    private a inferenceInterface = new a(ApplicationImpl.getApplication().getAssets(), getCnnModelPath());

    static {
        System.loadLibrary("tensorflow_inference_mz");
    }

    public static String getCnnModelPath() {
        return getSzPath() + "model/pbmodel-Android.pb";
    }

    public static String getDataPath() {
        return getSzPath() + "data";
    }

    public static String getParamPath() {
        return getSzPath() + "model/training_params.json";
    }

    public static String getStopwordsPath() {
        return getSzPath() + "dict/stopwords.dict";
    }

    public static String getSzFileFullPath() {
        return getSzPath() + "model.zip";
    }

    public static String getSzPath() {
        return ApplicationImpl.getApplication().getCacheDir() + "/notification/";
    }

    public static String getVersion() {
        return "v0.1";
    }

    public static String getW2vModelPath() {
        return getSzPath() + "model/word2vec_reduce.model";
    }

    public static String getWlUnzipFileFullPath() {
        return getSzPath() + "white_list.db";
    }

    public static String getWlZipFileFullPath() {
        return getSzPath() + "whitelist.zip";
    }

    public static boolean isFileExist() {
        return new File(getParamPath()).exists() && new File(getCnnModelPath()).exists() && new File(getW2vModelPath()).exists() && new File(getStopwordsPath()).exists();
    }

    private void test() throws IOException {
        System.currentTimeMillis();
        InputStream resourceAsStream = getClass().getResourceAsStream(PROB_EMIT);
        String str = "efo";
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, Charset.forName(Constants.UTF_8_CODE)));
                HashMap map = null;
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    String[] strArrSplit = line.split(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                    if (strArrSplit.length == 1) {
                        map = new HashMap();
                    } else {
                        map.put(Character.valueOf(strArrSplit[0].charAt(0)), Double.valueOf(strArrSplit[1]));
                    }
                    str = line;
                }
                if (resourceAsStream == null) {
                    return;
                }
            } catch (Exception e4) {
                Log.e("xxx", "lastLine = " + str);
                e4.printStackTrace();
                if (resourceAsStream == null) {
                    return;
                }
            }
            try {
                resourceAsStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public boolean isUchar(Character ch2) {
        if (ch2.charValue() >= 19968 && ch2.charValue() <= 40869) {
            return true;
        }
        if (ch2.charValue() < '0' || ch2.charValue() > '9') {
            return (ch2.charValue() >= 'A' && ch2.charValue() <= 'Z') || (ch2.charValue() >= 'a' && ch2.charValue() <= 'z');
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [s3.a] */
    /* JADX WARN: Type inference failed for: r2v13, types: [s3.a] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v9, types: [s3.a] */
    public PredictVo predict(String str) throws Throwable {
        char c4;
        ArrayList arrayList;
        String str2;
        ArrayList arrayList2;
        Session session;
        a aVar;
        PredictVo predictVo = new PredictVo();
        LinkedList linkedList = new LinkedList();
        P1.a aVar2 = P1.a.SIMPLIFIED;
        aVar2.getClass();
        StringReader stringReader = new StringReader(str);
        StringWriter stringWriter = new StringWriter();
        try {
            aVar2.a(stringReader, stringWriter);
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        char[] charArray = strQ2B(stringWriter.toString().toLowerCase()).toCharArray();
        int length = charArray.length;
        int i4 = 0;
        String str3 = "";
        int i5 = 0;
        while (true) {
            c4 = ' ';
            if (i5 >= length) {
                break;
            }
            char c5 = charArray[i5];
            Character chValueOf = Character.valueOf(c5);
            if (isUchar(chValueOf) || c5 == ' ') {
                str3 = str3 + chValueOf;
            }
            i5++;
        }
        String[] strArrSplit = str3.split(AwarenessDataItem.PERMISSION_SPLITTER);
        int maxSentenceLength = this.params.getMaxSentenceLength() - 4;
        int length2 = strArrSplit.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length2) {
            String str4 = strArrSplit[i6];
            if (str4.startsWith("action3") || str4.startsWith("packagename3") || str4.startsWith("classname3")) {
                linkedList.add(str4);
            } else {
                char[] charArray2 = str4.toCharArray();
                int length3 = charArray2.length;
                int i8 = 0;
                while (i8 < length3) {
                    char c6 = charArray2[i8];
                    Character chValueOf2 = Character.valueOf(c6);
                    if (i7 > maxSentenceLength || c6 == c4 || this.stopwords.indexOf(chValueOf2.toString()) != -1 || !isUchar(chValueOf2)) {
                        if (i7 == maxSentenceLength) {
                            break;
                        }
                    } else {
                        linkedList.add(chValueOf2.toString());
                        i7++;
                    }
                    i8++;
                    c4 = ' ';
                }
            }
            i6++;
            c4 = ' ';
        }
        float[] fArr = new float[this.w2vModel.getVector_size()];
        float[] value = this.w2vModel.getValue("<PADDING>");
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, this.params.getMaxSentenceLength(), this.w2vModel.getVector_size());
        int i9 = 0;
        while (i9 < linkedList.size()) {
            float[] value2 = this.w2vModel.getValue((String) linkedList.get(i9));
            if (value2 != null) {
                fArr2[i9] = value2;
            } else {
                fArr2[i9] = fArr;
            }
            i9++;
        }
        while (i9 < this.params.getMaxSentenceLength()) {
            fArr2[i9] = value;
            i9++;
        }
        float[] fArr3 = new float[this.w2vModel.getVector_size() * this.params.getMaxSentenceLength()];
        for (int i10 = 0; i10 < this.params.getMaxSentenceLength(); i10++) {
            for (int i11 = 0; i11 < this.w2vModel.getVector_size(); i11++) {
                fArr3[(this.w2vModel.getVector_size() * i10) + i11] = fArr2[i10][i11];
            }
        }
        this.inferenceInterface.c("input_x", fArr3, 1, this.params.getMaxSentenceLength(), this.w2vModel.getVector_size());
        this.inferenceInterface.c("dropout_keep_prob", new float[]{1.0f}, 1);
        ?? r22 = this.inferenceInterface;
        String str5 = "output/scores_softmax";
        String[] strArr = {"output/predictions", "output/scores_softmax"};
        String str6 = ", ";
        r22.b();
        int i12 = 0;
        while (true) {
            arrayList = r22.f14260f;
            if (i12 >= 2) {
                break;
            }
            String str7 = strArr[i12];
            arrayList.add(str7);
            C0186l c0186lD = C0186l.d(str7);
            C0238z c0238z = r22.f14257c;
            ((ArrayList) c0238z.f3214c).add(new d(c0238z.e((String) c0186lD.f2661c), c0186lD.f2660b));
            i12++;
        }
        Session session2 = r22.f14256b;
        try {
            try {
                try {
                    C0238z c0238z2 = r22.f14257c;
                    long[] jArr = new long[((ArrayList) c0238z2.f3213b).size()];
                    long[] jArr2 = new long[((ArrayList) c0238z2.f3212a).size()];
                    int[] iArr = new int[((ArrayList) c0238z2.f3212a).size()];
                    long[] jArr3 = new long[((ArrayList) c0238z2.f3214c).size()];
                    int[] iArr2 = new int[((ArrayList) c0238z2.f3214c).size()];
                    long[] jArr4 = new long[((ArrayList) c0238z2.f3215d).size()];
                    int size = ((ArrayList) c0238z2.f3214c).size();
                    arrayList2 = arrayList;
                    try {
                        long[] jArr5 = new long[size];
                        String str8 = str3;
                        Iterator it = ((ArrayList) c0238z2.f3213b).iterator();
                        int i13 = 0;
                        while (it.hasNext()) {
                            Iterator it2 = it;
                            int i14 = i13 + 1;
                            String str9 = str5;
                            str2 = str6;
                            try {
                                jArr[i13] = ((Tensor) it.next()).f13824a;
                                it = it2;
                                i13 = i14;
                                str5 = str9;
                                str6 = str2;
                            } catch (RuntimeException e5) {
                                e = e5;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Failed to run TensorFlow inference with inputs:[");
                                String str10 = str2;
                                sb.append(TextUtils.join(str10, r22.f14258d));
                                sb.append("], outputs:[");
                                sb.append(TextUtils.join(str10, arrayList2));
                                sb.append("]");
                                Log.e("TensorFlowInferenceInterface", sb.toString());
                                throw e;
                            }
                        }
                        String str11 = str5;
                        str2 = str6;
                        Iterator it3 = ((ArrayList) c0238z2.f3212a).iterator();
                        int i15 = 0;
                        r22 = r22;
                        while (it3.hasNext()) {
                            try {
                                d dVar = (d) it3.next();
                                Iterator it4 = it3;
                                aVar = r22;
                                try {
                                    jArr2[i15] = dVar.f14091a.f13817a;
                                    iArr[i15] = dVar.f14092b;
                                    i15++;
                                    it3 = it4;
                                    r22 = aVar;
                                } catch (RuntimeException e6) {
                                    e = e6;
                                    r22 = aVar;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Failed to run TensorFlow inference with inputs:[");
                                    String str102 = str2;
                                    sb2.append(TextUtils.join(str102, r22.f14258d));
                                    sb2.append("], outputs:[");
                                    sb2.append(TextUtils.join(str102, arrayList2));
                                    sb2.append("]");
                                    Log.e("TensorFlowInferenceInterface", sb2.toString());
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    session = session2;
                                    r22 = aVar;
                                    r22.a();
                                    r22.f14257c = session.b();
                                    throw th;
                                }
                            } catch (RuntimeException e7) {
                                e = e7;
                                StringBuilder sb22 = new StringBuilder();
                                sb22.append("Failed to run TensorFlow inference with inputs:[");
                                String str1022 = str2;
                                sb22.append(TextUtils.join(str1022, r22.f14258d));
                                sb22.append("], outputs:[");
                                sb22.append(TextUtils.join(str1022, arrayList2));
                                sb22.append("]");
                                Log.e("TensorFlowInferenceInterface", sb22.toString());
                                throw e;
                            } catch (Throwable th2) {
                                th = th2;
                                session = session2;
                                r22.a();
                                r22.f14257c = session.b();
                                throw th;
                            }
                        }
                        aVar = r22;
                        Iterator it5 = ((ArrayList) c0238z2.f3214c).iterator();
                        int i16 = 0;
                        while (it5.hasNext()) {
                            d dVar2 = (d) it5.next();
                            session = session2;
                            try {
                                try {
                                    jArr3[i16] = dVar2.f14091a.f13817a;
                                    iArr2[i16] = dVar2.f14092b;
                                    i16++;
                                    session2 = session;
                                } catch (RuntimeException e8) {
                                    e = e8;
                                    r22 = aVar;
                                    StringBuilder sb222 = new StringBuilder();
                                    sb222.append("Failed to run TensorFlow inference with inputs:[");
                                    String str10222 = str2;
                                    sb222.append(TextUtils.join(str10222, r22.f14258d));
                                    sb222.append("], outputs:[");
                                    sb222.append(TextUtils.join(str10222, arrayList2));
                                    sb222.append("]");
                                    Log.e("TensorFlowInferenceInterface", sb222.toString());
                                    throw e;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                r22 = aVar;
                                r22.a();
                                r22.f14257c = session.b();
                                throw th;
                            }
                        }
                        Session session3 = session2;
                        Iterator it6 = ((ArrayList) c0238z2.f3215d).iterator();
                        r22 = 0;
                        while (it6.hasNext()) {
                            jArr4[r22] = ((Operation) it6.next()).f13817a;
                            r22++;
                        }
                        try {
                            e eVar = new e(c0238z2);
                            try {
                                byte[] bArrRun = Session.run(((Session) c0238z2.f3217f).f13822d, (byte[]) c0238z2.f3216e, jArr, jArr2, iArr, jArr3, iArr2, jArr4, false, jArr5);
                                eVar.close();
                                ArrayList arrayList3 = new ArrayList();
                                for (int i17 = 0; i17 < size; i17++) {
                                    try {
                                        arrayList3.add(Tensor.d(jArr5[i17]));
                                    } catch (Exception e9) {
                                        Iterator it7 = arrayList3.iterator();
                                        while (it7.hasNext()) {
                                            ((Tensor) it7.next()).close();
                                        }
                                        arrayList3.clear();
                                        throw e9;
                                    }
                                }
                                c cVar = new c(10);
                                cVar.f136a = arrayList3;
                                cVar.f137b = bArrRun;
                                aVar.f14261g = arrayList3;
                                aVar.a();
                                aVar.f14257c = session3.b();
                                int length4 = this.params.getTags().length;
                                float[] fArr4 = new float[length4];
                                a aVar3 = this.inferenceInterface;
                                aVar3.getClass();
                                FloatBuffer floatBufferWrap = FloatBuffer.wrap(fArr4);
                                Iterator it8 = aVar3.f14260f.iterator();
                                int i18 = 0;
                                while (it8.hasNext()) {
                                    String str12 = str11;
                                    if (((String) it8.next()).equals(str12)) {
                                        Tensor tensor = (Tensor) aVar3.f14261g.get(i18);
                                        r3.a aVar4 = tensor.f13825b;
                                        if (aVar4 != r3.a.FLOAT) {
                                            throw new IllegalArgumentException("cannot use " + floatBufferWrap.getClass().getName() + " with Tensor of type " + aVar4);
                                        }
                                        floatBufferWrap.put(tensor.a().asFloatBuffer());
                                        for (int i19 = 0; i19 < length4; i19++) {
                                            if (fArr4[i4] < fArr4[i19]) {
                                                i4 = i19;
                                            }
                                        }
                                        predictVo.setTag(this.params.getTags()[i4]);
                                        predictVo.setContent(str8);
                                        predictVo.setScore(fArr4[i4]);
                                        return predictVo;
                                    }
                                    i18++;
                                    str11 = str12;
                                }
                                throw new RuntimeException("Node 'output/scores_softmax' was not provided to run(), so it cannot be read");
                            } catch (Throwable th4) {
                                eVar.close();
                                throw th4;
                            }
                        } catch (RuntimeException e10) {
                            e = e10;
                            StringBuilder sb2222 = new StringBuilder();
                            sb2222.append("Failed to run TensorFlow inference with inputs:[");
                            String str102222 = str2;
                            sb2222.append(TextUtils.join(str102222, r22.f14258d));
                            sb2222.append("], outputs:[");
                            sb2222.append(TextUtils.join(str102222, arrayList2));
                            sb2222.append("]");
                            Log.e("TensorFlowInferenceInterface", sb2222.toString());
                            throw e;
                        }
                    } catch (RuntimeException e11) {
                        e = e11;
                        str2 = str6;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (RuntimeException e12) {
                e = e12;
                str2 = ", ";
                arrayList2 = arrayList;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String strQ2B(String str) {
        String string = "";
        for (char c4 : str.toCharArray()) {
            if (c4 == 12288) {
                c4 = 32;
            } else if (c4 >= 65281 && c4 <= 65374) {
                c4 -= 65248;
            }
            StringBuilder sbS = g.s(string);
            sbS.append((char) c4);
            string = sbS.toString();
        }
        return string;
    }
}
