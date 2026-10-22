package c4;

import com.github.houbb.opencc4j.exception.Opencc4jRuntimeException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public static HashMap a(String str) throws IOException {
        try {
            InputStream resourceAsStream = b.class.getResourceAsStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, Charset.forName("UTF-8")));
                try {
                    HashMap map = new HashMap();
                    while (bufferedReader.ready()) {
                        String line = bufferedReader.readLine();
                        if (!s3.a.a(line)) {
                            String[] strArrSplit = s3.a.a(line) ? new String[0] : line.split("\\s+|\u0013");
                            ArrayList arrayList = new ArrayList();
                            for (int i10 = 1; i10 < strArrSplit.length; i10++) {
                                String str2 = strArrSplit[i10];
                                if (!"𫗵".equals(str2)) {
                                    arrayList.add(str2);
                                }
                            }
                            List list = t3.a.f12936a;
                            if (!arrayList.isEmpty()) {
                                map.put(strArrSplit[0], arrayList);
                            }
                        }
                    }
                    bufferedReader.close();
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException e10) {
            throw new Opencc4jRuntimeException("Dict 数据加载失败!", e10);
        }
    }
}
