package zc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Hashtable<String, a> f14306a = new Hashtable<>();

    /* renamed from: b, reason: collision with root package name */
    public String f14307b;

    /* renamed from: c, reason: collision with root package name */
    public a f14308c;

    public final synchronized void a(BufferedInputStream bufferedInputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(bufferedInputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            String[] strArrSplit = line.split(" ");
                            if (strArrSplit.length == 2) {
                                a aVar = new a();
                                aVar.f14307b = strArrSplit[1];
                                this.f14306a.put(strArrSplit[0], aVar);
                            }
                        } else {
                            inputStreamReader.close();
                            bufferedReader.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public final synchronized void b(BufferedInputStream bufferedInputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(bufferedInputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            String[] strArrSplit = line.split(" ");
                            if (strArrSplit.length == 2) {
                                int i10 = 0;
                                String str = strArrSplit[0];
                                String str2 = strArrSplit[1];
                                char[] charArray = str.toCharArray();
                                a aVar = this;
                                while (true) {
                                    if (i10 >= charArray.length) {
                                        break;
                                    }
                                    String upperCase = Integer.toHexString(charArray[i10]).toUpperCase();
                                    a aVar2 = aVar.f14306a.get(upperCase);
                                    if (aVar2 == null) {
                                        aVar.f14306a.put(upperCase, new a());
                                        aVar2 = aVar.f14306a.get(upperCase);
                                    }
                                    a aVar3 = aVar2.f14308c;
                                    if (charArray.length - 1 == i10) {
                                        aVar2.f14307b = str2;
                                        break;
                                    }
                                    if (aVar3 != null) {
                                        aVar = aVar3;
                                    } else if (charArray.length - 1 != i10) {
                                        aVar = new a();
                                        aVar2.f14308c = aVar;
                                        aVar.f14306a.put(Integer.toHexString(charArray[i10 + 1]).toUpperCase(), new a());
                                    }
                                    i10++;
                                }
                            }
                        } else {
                            inputStreamReader.close();
                            bufferedReader.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader == null) {
                            throw th;
                        }
                        bufferedReader.close();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }
}
