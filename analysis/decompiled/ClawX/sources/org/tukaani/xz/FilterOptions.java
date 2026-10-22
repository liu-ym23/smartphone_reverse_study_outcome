package org.tukaani.xz;

import java.io.InputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class FilterOptions implements Cloneable {
    public static int getDecoderMemoryUsage(FilterOptions[] filterOptionsArr) {
        int decoderMemoryUsage = 0;
        for (FilterOptions filterOptions : filterOptionsArr) {
            decoderMemoryUsage += filterOptions.getDecoderMemoryUsage();
        }
        return decoderMemoryUsage;
    }

    public static int getEncoderMemoryUsage(FilterOptions[] filterOptionsArr) {
        int encoderMemoryUsage = 0;
        for (FilterOptions filterOptions : filterOptionsArr) {
            encoderMemoryUsage += filterOptions.getEncoderMemoryUsage();
        }
        return encoderMemoryUsage;
    }

    public abstract int getDecoderMemoryUsage();

    public abstract int getEncoderMemoryUsage();

    public abstract FilterEncoder getFilterEncoder();

    public InputStream getInputStream(InputStream inputStream) {
        return getInputStream(inputStream, ArrayCache.getDefaultCache());
    }

    public abstract InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache);

    public FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream) {
        return getOutputStream(finishableOutputStream, ArrayCache.getDefaultCache());
    }

    public abstract FinishableOutputStream getOutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache);
}
