package org.apache.commons.math.random;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.apache.commons.math.stat.descriptive.StatisticalSummary;
import org.apache.commons.math.stat.descriptive.SummaryStatistics;

/* JADX INFO: loaded from: classes3.dex */
public interface EmpiricalDistribution {
    int getBinCount();

    List<SummaryStatistics> getBinStats();

    double getNextValue() throws IllegalStateException;

    StatisticalSummary getSampleStats() throws IllegalStateException;

    double[] getUpperBounds();

    boolean isLoaded();

    void load(File r1) throws IOException;

    void load(URL r1) throws IOException;

    void load(double[] r1);
}
