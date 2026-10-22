package com.obric.agent.intents.music.netease;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.bytedance.crypto.platform.RDAssetsProtection;
import com.bytedance.crypto.utils.CertUtils;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.s;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: CloudMusicConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f14799b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final i f14800c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, String> f14801d = null;

    /* JADX INFO: renamed from: lambda$S7j8WDofW_9OKuZ_p9r-hFnEzXo, reason: not valid java name */
    public static /* synthetic */ String m84lambda$S7j8WDofW_9OKuZ_p9rhFnEzXo() {
        return e();
    }

    private e() {
    }

    static {
        f14798a = new e();
        f14799b = d.g.a($$Lambda$e$S7j8WDofW_9OKuZ_p9rhFnEzXo.INSTANCE);
        String r3 = UUID.randomUUID().toString();
        o.c(r3, "toString(...)");
        String r5 = IAppContext.Companion.getVersionName();
        String r1 = Build.VERSION.RELEASE;
        if (r1 != null) goto L5;
        String r7 = "";
    L6:
        String r2 = Build.MODEL;
        if (r2 != null) goto L9;
        String r9 = "";
    L10:
        f14800c = new i("doubao_cmapi", r3, "openapi", r5, "openapi", r7, "doubao_cmapi", r9, "127.0.0.1", "wifi", "init");
        f14801d = ao.a(new d.m[]{s.a("pacific", "//8AAAEHcGFjaWZpYwAAAET//wAA//EAAtVNkwBMU9o1LwNo+AK94L9wj0UKp6qdvzua7KbfU1Op\n08AWRX7zoOKVnYf9Qqa1doxaoXLOB+x4h02lCgAABN0sFxgi0BLYBxOZgjD8WteQf5E3pXWoi5ZY\nFCN8YRU+7fJFbFxU6c/nJo2+LgqmZWqH+IUm5NVf42u5xKFvpauP4dj0IyBLIqFiBYwBEntQ7wbc\nAi95nHv37kSPjZFO80sFxPLohekT8Rz8g0znsZQ0WgbfVqTXOe1WZ893z5gP2su9VJXwX9pBC4Wu\ndeUQ1CP8XHLzclMMslsOzb/x8mOvCZBgd7WEaL55jEcvsBueYzVzUnLTfsYDLTDJO7dVy35fMJSU\nPOOaU4LP2JWoc4qwStjxATWEJF1Bnljtxn8GjVR5DbCkVwSgBWuJBnmx/ddtI/UCplVMdVnebf7N\nAogolroL61ZdCk5iZYw7Ub2UNApRmkpa3Hat6MGZSDGwRJZ0yAcghnDXL0+oMMR4FLAHWdTRiBu7\npwdavb7hDhAbHN54ZZwo0VnMuMQ3WfwBwirS3kG/tidp/sY6BQdWRnYuEfusTM+VoUlSMLZEjM8K\n1SvV1zeNLLBL8PVsx8SEJ6eL5NUp/VAKTHYnT9T5dM85S3OKa2/cpsr3O+0ny1VlKKq5HvousiIu\n30x86zah+EEGwWy2UBwbOYqqeXGKopiztEDVh28squ8ugdVIG4jS8v7NEVVBtXeaLkpDJulh0TuH\nGpz/6izQTWUjumys4RXRKxP+pl65TQuINLHDLhWoVbtHF7tiLhUL0GnX2ok6JKRUY1VrgcrRDwqY\n1M45MzhC3uQhDt4u7gHdpHlGYHXXFeFvaI9MUAKrJhQ5qIYcnBnxopTyuyUW7uRSptnZVs87eG4S\nF/fTUcyYoUmMf+wrZzUsRVAmkyioelgOWRrNj7IYTgljFs/OFZB/WbmiJIpvGbvq5C1YOze2YB5k\n9mlX5vuXSdkmRX465BkcybyGdh5vMPxKPXIgfk/IUgyTwGJrPNZWZGZ1s734rrlfXUb2LXmpsE65\nq1mVS/tc9lwdfhAVZkidvUX7VbxM1ZxBowGu2VXHMAuZNx54J84DYt1MQUfi7MKweMmGCSr+MJxC\n8ZKp6OpJWc5auIjxzv2/3I9ueEwJ5bnLTP9WMlH38AiJxdKS/w3A6dL8UZdC/9aNIg3akP8yBxM6\nrdBmlX/DGjIjEfRJwaC/l4Vd39JmJ4MZ6EDXxgK7EeD6dQsqcOt1EtD99P97XJZ1NUMfLjEMmAwA\n7MdmYZAEAxlNK0+EHAdH/tHqG3X0MtcYsvO2b8IUrGzYN2DuuFIvA+jRktb/frdpw33T6iJo69Y/\nTEleLB+jLbzTcVBz8qqEU4fvi2BYynKjg4V0KuR9ikwJeXk04wm8jAVsNOh4XWg4nrmhLOtqtzQq\nqsZWuumGSnbjhHz9VFuObQuEOApeZp68GXbDlYWDbj9V7d2IH9PQuSvX8xUnaNt8nssB7be653sz\n5YU3He4P9QOMb4RzUT1iUVgM8zblmz9XTqYwffHFmEl1jAAIwOH1WwPyQcKJzg1HJNlwAOxq59M7\nOQvtR1T6RJDiQYQ581WjxvnmLu0BcMBs/3NDDhSGA1OBlVA0bNJsPv7qKPU2HxsPGGNskAYAWsc9\nKekAdSuEcRcaOx9V7MkonyurJ2DrsZwqTTRfCoKAf5KNIO083We14720xAMjyqlAxEv5oc2adlNI\niAjuPaEBUtQGxYpTbwa8lPY9oIDIUSM="), s.a(IFeatureServiceKt.PRODUCT_NERIDA_LITE, "//8AAAEGbmVyaWRhAAAARP//AAD/8QACfC84Z/4mq3HdsX89K/EiM2FP4oGgg740LLSbFRYScSyX\nvBvNeCma3vhwudKQ6Ow+BS6RmNRZ/UQ1225LAAAE3cEb0dtP/XA0zniNA2jN4lbrR/2hV8xEIKUg\nQ9ByklD8s06ZWO+pE34VXLKGNlF2W/uh697Ns2jB219uPIRTH8zR9NG5iMNu394R8T5ri9b+ynE9\n8bPhDGyMQxZXUUGH05nuY+qvqucReD3FB7+3mMqCnposBoztfjuOfGArOwfseGcQW6T96xgiJbFE\nvhfhWhbOuKCTd+1cU7F2dA9rAg+YpFGEizCEP17R2oF9uOB9phYPUwBiWz37pBxDFwltIBVq7/q1\nlBX/7y7rLCyzM5CuDrjH5ag2Oc4RS8izW5y7LXFiAjopEsDcGiWB1p4BEq7sEVBQNfihtZ75Iy4h\nXi1dvshhOM0LUuUzO4jkJUxS0+NKnw3d9SN2JA8vAEeXFl3+PnXormIHQjTzn6lWBh7/pHQFdy0Y\n09Xt0P400xdVEWlQMubCPAnJM2P5RFxFyUo6fOm7YMwux2NUT1Yzal3Jt/ohu0LySl45e/8YvF5x\nDtaV0mn27B9PlvZ40IMYZWbHuugV2vzsPk0alDtsrOEHF8B0gBrH0NRfLGtA0G38IUhyrdsk3sfD\nn4S64auL8f28jv1ICe3xj4JXymAWBuLesiEjIEqYt3TIVjVz2+qYpDYryxQfaQLU0kcA5linZ4u2\nQ0pZ6X1/YG2MV7ZaSp42D8JewTOvZmNZKGWYm0lP+MS3RTVnpfkJXLGn09911Y6XrfoZW94DB96y\ndOm9Xz+2NFTzQqc7rF6368ya/yuXzkIKgGB8i4IJd3C7WXdQlndU4e+lZSZL2emUpYKO5X60clIe\nygtdifAJUh/zlZCiyQv6f9I2z6RuOWV53PZMkHM+/aEej+EuwoRW2dcqCv5wemTX5+OFcJn4uzBX\nwfTjwiPthWx0i5+0kR5GPkG3WJqeE7cufE411p97fYVl9omHZAO5tmr915z3v5XO5fgJponsFpWK\nl+TSZUXd3Xw2JxSgfHPCgEcTr3zqYzPyzUDzhlp287mnl7Hs1hzg1z1l8rqXswgL0htHzJ5dQWm2\nHXpicNOZx703X0KCOz4SsFWLhbwXIxJLpyAt6wwahzauqTGY8XGZSRS0pdozT6YVA6lyDkUBFyyK\nFGYD6TiRy4Z0RSGO8sGbEgqYQYS+WuX6nQYK1j1taIO8UcFrgupl19rEDRduBwHhu1FW58vZmgVx\nO/gf+flrun3h2NpQFbDCSt3YP+eKdcfbzAcX4jpiOxtf+9Ov2RxvExt08QLAdv6ZQdP4ZMP5YJvn\niEntovdDVkuOMMRhU7onhhdR8t8mQ6oM8gIsKw3dToN/dO5fZTG11Xz5q+GEiPKl7xqtDV9e5h8p\neKNhoaZqeJk0Z5GzczVMmuHAYVSTcEL53a280A8O+moulFkpz+HpzzDYWMHxJ3k4tk0zlGqF4CaU\nsZCzpWAA+2C1zsvQS8roGGVjCccgBTRSnK1AiZS+jKZ3G+R4QqwAW7LyAlHqx+15n6HwuxlikCZe\nf3c7hG+J+MO+8MLTmYfECxjJZZfYcUBGUr0QRREIGvwHkH7jiPX42PAFnJ8serfPZmM1J3xAZnCq\n7ZWVo/526kDrGTIGWrq+yX3JXKyI7jxxTyEOhHlf40qJBpKHKs2RskaeOzPRssF9n3RP7boEWxEN\nThpuFPWR1zpStM8KGqbecLy7eshJkg== "), s.a(IFeatureServiceKt.PRODUCT_NERIDA, "//8AAAEGbmVyaWRhAAAARP//AAD/8QACSf9OiTRTgx/HB+DIym+Y4YK4qqednpNxbg5Lr73BmmSh\nLNU7bnScFWv8FdjC3k4TlHpNNmp9RNBaDcjdAAAE3TbKo4iLEsA0nf7rvBQek2sXdSkaodKgIYZm\nDv2BpgguGfm1KZv27UTHseAudWILIqeh6I2MrYvLF0v9UVZR/dmi44BRxIj14uVWiF2aQJDgv56p\nrVDbbwuEQbshTQwhUsBUNevNbLBWAg7Tj2S+u7yk+PSmc2y4xjy8DTaaNIAwl3W27uP74ufuy8rr\nQ7DE+OrxPgnK7VTWAG5FReTEb1WWLlrXma5NL2IrbbL/zWl7KAtkAavp7+CJFeUFQ5v5iozRxLXG\nwnquXhW9rUBH2tpUBOS7InMmw+Lvvot+b1RNt+GWwEkuFzshWEp99TRhMPo86Qy9vDIO7BLC/lCm\njkHJ/ky/GhbySy/lUapDtghe6K/GnN/q4v+o9xEEYgFQS5zgndtYo7mvp/9lAZUn/10rXrBx3GTN\nVFB/tzurioEE9VH7cCwbW9k4T2lpl70KfaDuNDQbzVj13W50A2a4O2Ayi6N6IOhRvmbwG+h0wJmt\nhGUI2RhZCu4z9uiMAAiayEJlRKIkzTtR8lmK+C2Jo+pks0IYiH0EhbPrPoBwTtBOE7oFazaiaWGH\nNTMjiLDXRfTWyRYe9G9JWYfRTbJPB7A5cjmxb1/3H1yPZPjF3oqZSJRi/EmmiJ1iXmMFFr6HoHZe\nZxqCLRogWAu72sOb6yvpetgkuhFbd+E84koN++y4jFf956nJGSyQKFWKYOHbznqvvYIir/Uc7s2X\nhPIEWK0ShT9vauDixUzwhHiNvjVJwLZd79sl7EBOn1VTeBvrzYM6DuFfwzHdKy3fsM4FqhGtJ+mK\nxdEqrAcWYz9frAJ/n3uCYKpOanJYp7pQFLdZn6H3RZ+uOrbSSpEjNl7FzTe3mV14beFUSVnWdu/H\ncSUDB7PUKxh0k1357TC/4wuXocMoOInLzPHdy+hPvZG7HpNgapENixPuua4Asm9tZdt8qGwWsxQq\nUQQfZ0Q3rTYPsdyHHBVeX2xVypZD3vKE8zqub03vg/AR6PYo3wR5Oy604FaUMTVxu59ZdM6kj6CG\n8M4a/eW5VCPHe8veXmzI5kXFsOs5UmmfNyFwywBiebLLVO4To6xRS78zW/b8FB516OCRcarivivR\njfffC2Jujyc7ivqvB3zGEmwprCXlui/MKeIppVxeSBkwFA4bFjBVC0liHHHlN8mlYUQWopsVH2Ne\nA9nkRw8hhR8MQES5H+QFz7L8RwEuJdY21Ja4XzfNUavBG1nB0rIX+GNsPxDUarasqiscjlMk0gJW\npL8kJE1XHjYLYOo2R7zEbkRox5h3PEYPBtP97e7pyMeXJdRwtEsTVHFKStgxQ1daIkWvbuVUSawr\n0m+OhZBraF0dud/9WRvgyBFQD43a7GXG3RtBI1WUszU8FqmByrnuCrCiEEdnWFHAEQBVMrcs/UTJ\nL/jO9Huz09lOePfROKtMYnVtT4bnwuqAd5d20FS7DCDUxLHkFOTe3/wnGDV3uCSR4KV1KvoQZzrY\n/a/eSw3yrQX384aczkbC0rKQ3SJfZa74p4ItR+r9uIZnotBJsub1AC9NODrPjAKCYIlhrhWKw53H\nXP1GQ/EAOOws3THNA3dRCuVT7WnALPQf6PIjLsEglv0Y9+qE8FC6GbR45SFEhNLWEeBp+/uUIg62\nTtCYr6MdmAAFPvnsmxhfx2oqzerVaA=="), s.a(IFeatureServiceKt.PRODUCT_PIKE, "//8AAAEEcGlrZQAAAET//wAA//EAAmxsILyroU6YGkzTtJexOdJDPObg0Ur8sKAT476T2wy0dG4w\nRF6Qb3Y1FWbdiZDkIPu66B/2GzFGqUWq/QAABN3zX17WYo9Nayuad/nv4gKN2JWZIJJbr1Ff3gsp\n8szeBjKcbg5PdI/0BTlYK8iaHrX18MXX07ZL1jynEmhUjb8KlH8EsA3HC5FXO1mJSXMgy3jfo3IC\nS54wIZNxzsxYIsghRoQsQtb4mnfh54lTdfGBA4SJfsdd8Go91ouePOa8sapJe0h0fryHEfM1knnF\nfbFmAfu+796Yx9sBCeFOALf/8+kppwOx6kZmtW6jdgUkCKYSfApGGcavK4V1lmEl12lo5FPWI7wL\nx1HRDBmdm5IzFDpKYK5jUkwirIllqXTodMyOLh/mdgFbEIEcD6xnIRNhwrrTGCaCMPg+ICIBteCH\nlAwo7Qo2aM4WDBysoJ9fzLHG+2++pYGJcnH5gLMMS6RNfQGkHcsAsz+Nd3OsF62w87Y1CIB0WvAa\n7f8jztLWGA9++Wn01d/fiZ+C4gPcXQStGnXNosWkMbwvvuCmLGYw6V5Gch5+eZ6PobXf+VU7hby3\nBucQwqIKVBv7VtUeqpvjILdRkDZiJptvgo38NZzV5w20wQWpr6TWmx9nNSA1krozDXuFGbNB8DLW\nD0wQxjLHzeUUNJgaCy2pC7/kSFUX2OzllwO6GanYJz2ysZwKKH2I5LFo/asxS/1cFy+taTTId970\n/9Y84LFlTn4W+COSR59WeJQABUHzRYeojHClfL2LcIQ/mQiSF+R0zRpJYfO96kc55gUnzu9Qrfex\nUSrQyKDZX4+bdTKAFm8TotRLwKR0I4Pqz+vDFkrV0kKFnFjvfT9yKIH8oV6kH7woNGKkx0UIzPbe\ns/WUF5sHQ/WE/hY/T8wju1NHYMiT/ffJLPFBfNiLT8SIrpLcTdRQYKGe1tQBZowqNw/8bhYk81Kw\nq8N5KB3Yx1TzbK3cH4IxqTxRas8QIqFUfY3taA2gRenJvrTfAG6T/U1C/c6b+PEFYieHFRFJMRfL\nPZ4tjkW+vwWt33+9TA65+IhR8ZDuLP42tgjDqmGgdt5zcTLZwsn7mvXvzjkkWBULVRnkwHdjUbbJ\nxtawFEOLJD/ZRB2715a2n0ZDwvEj6vorp4yqdR6gGhpG8DczM5QXYaeBoWdpxbFAYNa0biZZmpPr\nCn3AuYG0fjU/4Ev0dForrxdFmrUfFDiCq3SNK7azHLydA5xcMG62jeLrnl1yJa95r/CTcf/D0MKq\n7l/MksbrkKE7h47koHnLZYGUofLIJ0Sc2/TbFlwQAwFUKkVthE8fug3xnE9lOrK263ll8xeOHtRR\nooeZMgoEJi5kgFDjnY7/uhGIG73zvUaVxa2fNZkoHXDfRCjAVvtcx1n+lb5USPunLwdxh665jagl\nXLA6OaTgpAOzrQ6qxAi4bdFJiIeATfuv2qr1ZJat4Up1Bb09Ytdira8d1xVqg7VBrp5mAOYDd5fl\niL1cylTeCopXmPNQfdD92X4qFSLVQuYRrZfYYp7nrNr8TDybGhdLXgTo4R8WEZ6H17cPv7nVUbp1\n1xXBvXPYLRQgGp6x2yjGZU/0JNrWA4TXMIE54biNsC0f/kp/MecshG47CwayQBRTtWllTjk1pLd4\nZbEe8FFzmmF/1iSYbvFp0irKhnCfocEQEr3bTPbRizIGweCR9xawtOMZlcgMMi03IAk7E3m02WTZ\nYiJeK6rSbjIIJ0YyLwUv1dHkN3M=")});
        return;
    L9:
        r9 = r2;
        goto L10
    L5:
        r7 = r1;
        goto L6
    }

    private static final String e() {
        return f14798a.d();
    }

    public final String a() {
        return (String) ZeusTransformUtils.preCheckCast(f14799b.b(), String.class, "com.obric.aiagent.plugin");
    }

    public final String b() {
        return IAppContext.Companion.getBuildChannel();
    }

    public final i c() {
        return f14800c;
    }

    private final String d() {
        String r10 = ObricProductSdk.INSTANCE.featureService().getObricProductName();
        Map<String, String> r0 = f14801d;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r0.get(r10), String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L5;
        r11 = (String) ZeusTransformUtils.preCheckCast(ao.b(r0, "pacific"), String.class, "com.obric.aiagent.plugin");
    L5:
        RDAssetsProtection r1 = RDAssetsProtection.getInstance();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        byte[] r3 = CertUtils.pemStringToEncodedPubKey("-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEnRIVZLMb7v2825kieLpmCBRDCl12\nIOu3d/6XxBYKeZk2fZYiFFg9zN3YobulUk0iz4ITCiRC7He9w3nKCJL0kQ==\n-----END PUBLIC KEY-----");
        Charset r4 = StandardCharsets.UTF_8;
        o.c(r4, "UTF_8");
        byte[] r5 = "obric_doubao_assistant".getBytes(r4);
        o.c(r5, "getBytes(...)");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        Appendable r6 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin");
        int r7 = 0;
    L7:
        if (r7 >= r12.length()) goto L12;
        char r8 = r12.charAt(r7);
        if (d.o.a.a(r8) == true) goto L11;
        r6.append(r8);
    L11:
        r7 = r7 + 1;
        goto L7
    L12:
        String r13 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r6, StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        o.c(r13, "toString(...)");
        byte[] r14 = Base64.encode(r1.decrypt(r2, r3, r5, Base64.decode(r13, 0)), 0);
        o.c(r14, "encode(...)");
        return new String(r14, d.o.d.f38623b);
    }
}
