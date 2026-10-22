package Z1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.time.YearMonth;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final SortedSet<YearMonth> f7110a = new TreeSet();

    /* renamed from: b, reason: collision with root package name */
    public final YearMonth f7111b;

    public c() throws IOException {
        try {
            InputStream resourceAsStream = c.class.getClassLoader().getResourceAsStream("leap_second_dates.csv");
            try {
                Objects.requireNonNull(resourceAsStream, "leap_second_dates.csv was not found on the classpath");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            resourceAsStream.close();
                            this.f7111b = this.f7110a.last();
                            return;
                        } else if (!line.isEmpty()) {
                            this.f7110a.add(YearMonth.parse(line));
                        }
                    } finally {
                    }
                }
            } finally {
            }
        } catch (IOException e10) {
            throw new UncheckedIOException(e10);
        }
    }

    @Override // Z1.e
    public YearMonth a() {
        return this.f7111b;
    }

    @Override // Z1.e
    public boolean b(YearMonth yearMonth) {
        return this.f7110a.contains(yearMonth);
    }
}
