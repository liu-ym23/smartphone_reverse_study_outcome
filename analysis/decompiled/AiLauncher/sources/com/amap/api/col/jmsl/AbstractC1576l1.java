package com.amap.api.col.jmsl;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.jmsl.l1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1576l1 extends C1 {
    protected Context mContext;
    protected byte[] mDatas;
    protected C1569j2 mSDKInfo;

    public AbstractC1576l1(Context context, C1569j2 c1569j2) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSDKInfo = c1569j2;
        setBinary(true);
    }

    private static byte[] c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(C1604s2.t("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                C1611u1.b(th2, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    C1611u1.b(th3, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1611u1.b(th4, "bre", "gbh");
                }
            }
        }
    }

    private byte[] d() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] rawDatas = getRawDatas();
            if (rawDatas != null && rawDatas.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(getDatasLength(rawDatas));
                byteArrayOutputStream.write(rawDatas);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (Throwable th) {
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray2;
            } catch (Throwable th2) {
                C1611u1.b(th2, "bre", "grrd");
                return byteArray2;
            }
        } catch (Throwable th3) {
            try {
                C1611u1.b(th3, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1611u1.b(th4, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    C1611u1.b(th5, "bre", "grrd");
                }
            }
        }
    }

    private byte[] e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] rsaAesRawDatas = getRsaAesRawDatas();
            if (rsaAesRawDatas != null && rsaAesRawDatas.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] bArrI = C1568j1.i(rsaAesRawDatas);
                byteArrayOutputStream.write(getDatasLength(bArrI));
                byteArrayOutputStream.write(bArrI);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (Throwable th) {
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray2;
            } catch (Throwable th2) {
                C1611u1.b(th2, "bre", "gred");
                return byteArray2;
            }
        } catch (Throwable th3) {
            try {
                C1611u1.b(th3, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1611u1.b(th4, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    C1611u1.b(th5, "bre", "gred");
                }
            }
        }
    }

    public byte[] getDatasLength(byte[] bArr) {
        return C1604s2.k(bArr.length, 2);
    }

    @Override // com.amap.api.col.jmsl.s7
    public final byte[] getEntityBytes() {
        byte[] bArr = this.mDatas;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(c());
            byteArrayOutputStream.write(getPublicData());
            byteArrayOutputStream.write(d());
            byteArrayOutputStream.write(e());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.mDatas = byteArray;
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                C1611u1.b(th2, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    C1611u1.b(th3, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1611u1.b(th4, "bre", "geb");
                }
            }
        }
    }

    public String getLogVersion() {
        return "2.1";
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        String strN = C1567j0.n(this.mContext);
        String strB = J0.b();
        String strD = J0.d(this.mContext, strB, "key=".concat(String.valueOf(strN)));
        HashMap map = new HashMap();
        map.put("ts", strB);
        map.put("key", strN);
        map.put("scode", strD);
        return map;
    }

    public String getPlatInfo() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.mSDKInfo.d(), this.mSDKInfo.g());
    }

    public byte[] getPublicData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (getXinfoFlag()) {
                Context context = this.mContext;
                boolean zIsLocRequest = isLocRequest();
                C1569j2 c1569j2 = this.mSDKInfo;
                byte[] bArrG = J0.g(context, zIsLocRequest, c1569j2 != null && "navi".equals(c1569j2.g()));
                byteArrayOutputStream.write(getDatasLength(bArrG));
                byteArrayOutputStream.write(bArrG);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] bArrT = C1604s2.t(getLogVersion());
            if (bArrT == null || bArrT.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(getDatasLength(bArrT));
                byteArrayOutputStream.write(bArrT);
            }
            byte[] bArrT2 = C1604s2.t(getPlatInfo());
            if (bArrT2 == null || bArrT2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(getDatasLength(bArrT2));
                byteArrayOutputStream.write(bArrT2);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                C1611u1.b(th2, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C1611u1.b(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1611u1.b(th4, "bre", "gred");
                }
            }
        }
    }

    public abstract byte[] getRawDatas();

    @Override // com.amap.api.col.jmsl.s7
    public abstract Map<String, String> getRequestHead();

    public abstract byte[] getRsaAesRawDatas();

    @Override // com.amap.api.col.jmsl.s7
    public abstract String getURL();

    public boolean getXinfoFlag() {
        return true;
    }

    public boolean isLocRequest() {
        return false;
    }
}
